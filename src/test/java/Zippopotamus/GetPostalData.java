package Zippopotamus;

import org.testng.annotations.Test;

/**
 * In this class we'll be testing the https://www.zippopotam.us/ API
 * Free API with JSON Response Format
 * Provide a Country and a zip code and you'll receive postal data
 * 
 * */
public class GetPostalData {

	/**
	 * US Postal Codes Business Rules
	 * United States ZIP codes are five numerical digits long
	 * The first digit in a ZIP code represents a defined group of U.S. states. 
	 * The second and third digits represent a region in that group, such as a large city.
	 * Last 2 digits are Associate Post office or delivery area
	 * */
	@Test
	public void CodesWithDifferentFirstDigitsShouldBeFromDifferentStates() {
		
	}

	@Test
	public void CodesWithDifferentSecondDigitsShouldBeFromDifferentCities() {
		
	}
	
	@Test
	public void CodesWithEqualFirstThreeDigitsShouldBeFromSameCities() {
		
	}
	
	@Test
	public void CodesWithEqualFirstThreeDigitsDifferentLastTwoDigitsShouldBeFromSameCitiesDifferentLatitudes() {
		
	}
}
