
package com.sogeti.assignment.countrydetails;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sogeti.assignment.countryresponsepojo.Root;
import com.sogeti.assignment.utility.Excelutility;
import com.sogeti.assignment.utility.StatusCodeContentTypeValidation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class CountryDetails{

	RequestSpecification httprequest;
	Response response;

	
	@BeforeMethod
	public void setupMethod() throws IOException {
		RestAssured.baseURI = "https://api.zippopotam.us";
		RestAssured.useRelaxedHTTPSValidation();
		httprequest = RestAssured.given();
		
	}
	
	
	@DataProvider(name = "excelDataGetMethod")
    public Object[][] excelDataProviderGetMethod() throws IOException {
		Excelutility exceldata = new Excelutility();		
		Object[][] arrObj = exceldata.getExcelData(System.getProperty("user.dir" )+ "/TestData.xlsx", "getMethodTestData");        
		return arrObj;
}
	
		

	@Test(retryAnalyzer = com.sogeti.assignment.utility.RetryAnalyzer.class)
	public void getCountryDetails() throws JsonMappingException, JsonProcessingException {
		

		response = httprequest.request(Method.GET,"/de/bw/stuttgart");
	    StatusCodeContentTypeValidation.passedStatusCodeValidation(response.getStatusCode());
		StatusCodeContentTypeValidation.contentTypeValidation(response.header("Content-Type"));
		StatusCodeContentTypeValidation.responseTimeValidation(response.getTimeIn(TimeUnit.SECONDS));
		ObjectMapper objmap = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Root root = objmap.readValue(response.getBody().asString(), Root.class);
		Assert.assertEquals(root.getCountry(), "Germany");
		Assert.assertEquals(root.getState(), "Baden-Württemberg");
		for(int i=0;i<root.getPlaces().size();i++) {
			root.getPlaces().get(i).getPostcode();
			if(root.getPlaces().get(i).getPostcode()=="70597") {
				Assert.assertEquals(root.getPlaces().get(i).getPlacename(),"Stuttgart Degerloch");
			}
		}	
	}
	
	
	
	
	@Test(dataProvider = "excelDataGetMethod" , priority = 1)
	public void getCountryDetailsDataDrivenApproch(String Country, String PostalCode, String PlaceName) throws JsonMappingException, JsonProcessingException{
				
			httprequest.pathParam("Country", Country);
			httprequest.pathParam("PostalCode", PostalCode);
			response = httprequest.request(Method.GET,"/{Country}/{PostalCode}");
		    StatusCodeContentTypeValidation.passedStatusCodeValidation(response.getStatusCode());
			StatusCodeContentTypeValidation.contentTypeValidation(response.header("Content-Type"));
			StatusCodeContentTypeValidation.responseTimeValidation(response.getTimeIn(TimeUnit.SECONDS));
			ObjectMapper objmap = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Root root = objmap.readValue(response.getBody().asString(), Root.class);
			Assert.assertEquals(root.getPlaces().get(0).getPlacename(),PlaceName);
				
		}
	
}


