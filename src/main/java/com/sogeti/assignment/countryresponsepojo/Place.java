package com.sogeti.assignment.countryresponsepojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {

	
	private String placeName;
    private String longitude;
    private String postCode;
    private String latitude;
	private String state;
	private String stateAbbreviation;
    

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("state abbreviation")
	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

	@JsonProperty("state abbreviation")
	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}

	@JsonProperty("place name")
	public String getPlacename() {
		return placeName;
	}
	
	@JsonProperty("place name")
	public void setPlacename(String placeName) {
		this.placeName = placeName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@JsonProperty("post code")
	public String getPostcode() {
		return postCode;
	}
	
	@JsonProperty("post code")
	public void setPostcode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	 
    
@Override
public String toString() {
	return "Tag [placename=" + placeName + ", longitude=" + longitude + ", postcode=" + postCode +", latitude=" +latitude+ "]";
}
}