package com.plymouth.comp2001.jsonldapi.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plymouth.comp2001.jsonldapi.model.LibraryJson;
import com.plymouth.comp2001.jsonldapi.model.LibraryJsonLd;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;

@Service
public class LibraryService
{
	private static final Logger logger = LoggerFactory.getLogger(LibraryService.class);
//	private static final String DATASET_URL = "https://storage.googleapis.com/thedataplace-plymouth/resources%2F7ca5c131-ba46-4133-ae6a-0dc8eb8a9281%2F040-02_location-of-libraries-2018.geojson";
	
	@Value("${dataset.url}")
	private String datasetUrl;
	
	private List<LibraryJson> libraryJsonList;
	private List<LibraryJsonLd> libraryJsonLdList;
	private ObjectMapper jsonLdObjectMapper;
	
	@PostConstruct
	private void init()
	{
		logger.info("initiating LibraryLocationService from {}", datasetUrl);
		
		jsonLdObjectMapper = new ObjectMapper();
		jsonLdObjectMapper.registerModule(new JsonldModule());
		
		libraryJsonList = retrieveLibraryJsonList(datasetUrl);
		libraryJsonLdList = makeLibraryJsonLdList(libraryJsonList);
	}
	
	public List<LibraryJson> getLibraryJsonList()
	{
		return libraryJsonList;
	}

	public List<LibraryJsonLd> getLibraryJsonLds()
	{
		return libraryJsonLdList;
	}
	
	public String getDatasetUrl()
	{
		return datasetUrl;
	}

	private List<LibraryJson> retrieveLibraryJsonList(String urlStr)
	{
		logger.info("retrieving library json list from {} ...", urlStr);
		List<LibraryJson> resultList = new ArrayList<LibraryJson>();
		try
		{
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream is = conn.getInputStream();
			
			ObjectMapper objMapper = new ObjectMapper();
//			GeoJsonObject gjo = objMapper.readValue(is, GeoJsonObject.class);
			FeatureCollection fc = objMapper.readValue(is, FeatureCollection.class);
			List<Feature> featureList = fc.getFeatures();
			for (int i = 0; i < featureList.size(); i++)
			{
				Feature feature = featureList.get(i);
				Map<String, Object> map = feature.getProperties();
				LibraryJson library = objMapper.convertValue(map, LibraryJson.class);
				resultList.add(library);
				logger.info("library[{}]: {}", (i+1), library.toString());
			}
			
			logger.info("total number of libraries: {}", resultList.size());
		}
		catch (IOException e)
		{
			logger.error("retrieve geo-json error!", e);
		}
		
		return resultList;
	}
	
	private List<LibraryJsonLd> makeLibraryJsonLdList(List<LibraryJson> jsonList)
	{
		logger.info("creating JSON-LD for libraries ...");
		
		List<LibraryJsonLd> resultList = new ArrayList<LibraryJsonLd>();
		for (int i = 0; i < jsonList.size(); i++)
		{
			LibraryJson json = jsonList.get(i);
			LibraryJsonLd jsonLd = new LibraryJsonLd();
			jsonLd.setFid(json.getFid().toString());
			jsonLd.setLibraryName(json.getLibraryName().trim());
			jsonLd.setAddressLine1(json.getAddressLine1());
			if (json.getAddressLine2() != null) {
				jsonLd.setAddressLine2(json.getAddressLine2().trim());
			}
			if (json.getAddressLine3() != null) {
				jsonLd.setAddressLine3(json.getAddressLine3().trim());
			}
			jsonLd.setPostcode(json.getPostcode());
			jsonLd.setLatitude(json.getLatitude());
			jsonLd.setLongitude(json.getLongitude());
			jsonLd.setWebsite(json.getWebsite());
			resultList.add(jsonLd);
		}
		
		return resultList;
	}
	
	public String getLibraryJsonLdString()
	{
		
//		objectMapper.registerModule(new JsonldModule(() -> objectMapper.createObjectNode()));
		
		String jsonStr = "";
		try
		{
			jsonStr = jsonLdObjectMapper.writeValueAsString(this.libraryJsonLdList);
//			JsonldResource resrc = JsonldResource.Builder.create().build(jsonLdList);
//			jsonStr = jsonLdObjectMapper.writer().writeValueAsString(resrc);
			logger.info("result: {}", jsonStr);
		}
		catch (JsonProcessingException e)
		{
			logger.error("convert to json-ld error!", e);
		}
		
		return jsonStr;
	}
}
