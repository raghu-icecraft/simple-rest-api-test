/*
 * Base reference - https://github.com/basdijkstra/workshops/tree/master/rest-assured/RestAssuredWorkshop
 * Specific Code reference - https://bit.ly/2OorfBZ
 */

package com.raghu.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleExamples {
	
	@Test
	public void useQueryParametersSingleTestcase() {

		given().
			params("text", "testcaseOne").
		when().
			get("http://md5.jsontest.com").
		then().
			body("md5",equalTo("4ff1c9b1d1f23c6def53f957b1ed827f"))
				.and()
			.body("original", equalTo("testcaseOne"));
	}


	@Test
	public void useSinglePathParameter() {

		given().
			pathParam("driverName", "max_verstappen").
		when().
			get("http://ergast.com/api/f1/drivers/{driverName}.json").
		then()
			.body("MRData.DriverTable.Drivers.permanentNumber[0]",equalTo("33"));			
	}
	


}
