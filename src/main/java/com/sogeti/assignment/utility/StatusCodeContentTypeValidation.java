package com.sogeti.assignment.utility;

import org.testng.Assert;

public class StatusCodeContentTypeValidation {


public static void passedStatusCodeValidation(int statuscode) {
	
	Assert.assertEquals(statuscode, 200);
}


public static void contentTypeValidation(String contentType) {
	
	Assert.assertEquals(contentType, "application/json");

	
}

public static void responseTimeValidation(long l) {
	
	Assert.assertEquals(l, 0);

	
}


}
