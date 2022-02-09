package Zippopotamus;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * In this class we'll be testing the https://www.zippopotam.us/ API
 * Free API with JSON Response Format
 * Provide a Country and a zip code and you'll receive postal data
 * 
 * */
public class GetPostalDataTests {
	/**
	 * US Postal Codes Business Rules
	 * United States ZIP codes are five numerical digits long
	 * The first digit in a ZIP code represents a defined group of U.S. states. 
	 * The second and third digits represent a region in that group, such as a large city.
	 * Last 2 digits are Associate Post office or delivery area
	 * */
	@Test
	public void CodesWithDifferentFirstDigitsShouldBeFromDifferentStates() {
		
		Response postalData1 = RestAssured.get("http://api.zippopotam.us/us/90210");
		Response postalData2 = RestAssured.get("http://api.zippopotam.us/us/10005");
		String zipCode1State = postalData1.body().jsonPath().get("places[0].state");
		String zipCode2State = postalData2.body().jsonPath().get("places[0].state");
		Assert.assertNotEquals(zipCode1State, zipCode2State, String.format("Expected %s to be different than %s",zipCode1State, zipCode2State ));
		
	}

	@Test
	public void CodesWithDifferentSecondDigitsShouldBeFromDifferentCities() {
		Response postalData1 = RestAssured.get("http://api.zippopotam.us/us/90210");
		Response postalData2 = RestAssured.get("http://api.zippopotam.us/us/90310");
		String zipCode1PlaceName = postalData1.body().jsonPath().get("places[0].'place name'");
		String zipCode2PlaceName = postalData2.body().jsonPath().get("places[0].'place name'");
		Assert.assertNotEquals(zipCode1PlaceName, zipCode2PlaceName, String.format("Expected %s to be different than %s",zipCode1PlaceName, zipCode2PlaceName ));
	}
	
	@Test
	public void CodesWithEqualFirstThreeDigitsShouldBeFromSameCities() {
		
	}
	
	@Test
	public void CodesWithEqualFirstThreeDigitsDifferentLastTwoDigitsShouldBeFromSameCitiesDifferentLatitudes() {
		
	}
	
}
