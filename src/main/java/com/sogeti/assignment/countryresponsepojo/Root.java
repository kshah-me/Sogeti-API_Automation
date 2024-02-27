package com.sogeti.assignment.countryresponsepojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
	
	private String countryAbbreviation;
	private ArrayList<Place> places;
	private String placeName;
	private String country;	
	private String state;
	private String stateAbbreviation;
	private String postCode;
	

	
	@JsonProperty("post code")
	public String getPostCode() {
		return postCode;
	}

	@JsonProperty("post code")
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
	
	
	@JsonProperty("country abbreviation")
	public String getCountryAbbreviation() {
		return countryAbbreviation;
	}

	@JsonProperty("country abbreviation")
	public void setCountryAbbreviation(String countryAbbreviation) {
		this.countryAbbreviation = countryAbbreviation;
	}


	public ArrayList<Place> getPlaces() {
		return places;
	}


	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}

	@JsonProperty("place name")
	public String getPlacename() {
		return placeName;
	}

	@JsonProperty("place name")
	public void setPlacename(String placeName) {
		this.placeName = placeName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

    
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


	
    
@Override
public String toString() {
	return "Tag [countryabbreviation=" + countryAbbreviation + ", places=" + places + ", placename=" + placeName +", country=" +country+", state=" +state+ ", stateabbreviation"+ stateAbbreviation +"]";
}
    
	
}
