package com.plymouth.comp2001.jsonldapi.model;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldResource
@JsonldNamespace(name = "plymouth-library-info", uri = "http://schema.org/")
@JsonldType("https://schema.org/Library")
public class LibraryJsonLd
{
	@JsonldId
	private String fid;
	
	@JsonldProperty("http://schema.org/name")
	private String name;
	
	@JsonldProperty("https://schema.org/address")
	private String address;
	
	@JsonldProperty("https://schema.org/postalCode")
	private String postalCode;
	
	@JsonldProperty("https://schema.org/latitude")
	private Double latitude;

	@JsonldProperty("https://schema.org/longitude")
	private Double longitude;
	
	// URL of a webpage that unambiguously indicates the item's identity (eg: official website)
	@JsonldProperty("http://schema.org/sameAs")
	private String sameAs;

	public String getFid()
	{
		return fid;
	}

	public void setFid(String fid)
	{
		this.fid = fid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
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

	public String getSameAs()
	{
		return sameAs;
	}

	public void setSameAs(String sameAs)
	{
		this.sameAs = sameAs;
	}
}
