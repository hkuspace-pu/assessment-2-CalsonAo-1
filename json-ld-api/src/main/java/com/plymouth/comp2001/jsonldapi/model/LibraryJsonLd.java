package com.plymouth.comp2001.jsonldapi.model;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldResource
@JsonldNamespace(name = "library", uri = "http://schema.org/")
@JsonldType("https://schema.org/Place")
public class LibraryJsonLd
{
	@JsonldId
	private String fid;
	
	@JsonldProperty("http://schema.org/name")
	private String libraryName;
	
	@JsonldProperty("https://schema.org/address")
	private String addressLine1;
	
	@JsonldProperty("https://schema.org/address")
	private String addressLine2;
	
	@JsonldProperty("https://schema.org/address")
	private String addressLine3;
	
	@JsonldProperty("https://schema.org/postalCode")
	private String postcode;
	
	@JsonldProperty("https://schema.org/latitude")
	private Double latitude;

	@JsonldProperty("https://schema.org/longitude")
	private Double longitude;
	
	@JsonldProperty("http://schema.org/url")
	private String website;
	
	public String getFid()
	{
		return fid;
	}

	public void setFid(String fid)
	{
		this.fid = fid;
	}

	public String getLibraryName()
	{
		return libraryName;
	}

	public void setLibraryName(String libraryName)
	{
		this.libraryName = libraryName;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2()
	{
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3()
	{
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3)
	{
		this.addressLine3 = addressLine3;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public Double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}
}
