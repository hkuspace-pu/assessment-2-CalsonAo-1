package com.plymouth.comp2001.jsonldapi.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LibraryJson
{
	@JsonProperty("fid")
	private Integer fid;
	
	@JsonProperty("LibraryName")
	private String libraryName;
	
	@JsonProperty("AddressLine1")
	private String addressLine1;
	
	@JsonProperty("AddressLine2")
	private String addressLine2;
	
	@JsonProperty("AddressLine3")
	private String addressLine3;
	
	@JsonProperty("Postcode")
	private String postcode;
	
	@JsonProperty("Latitude")
	private Double latitude;
	
	@JsonProperty("Longitude")
	private Double longitude;
	
	@JsonProperty("Website")
	private String website;
	
	@Override
	public String toString()
	{
		String body = ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
		return body;
	}

	public Integer getFid()
	{
		return fid;
	}

	public void setFid(Integer fid)
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
