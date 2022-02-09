package Common;

import org.testng.Assert;
import io.restassured.response.Response;

public class GetTests {
	static void GenericGetCallTests(Response response) {
		int statusCode = response.getStatusCode();
		String contentType = response.getHeader("Content-Type");
		Assert.assertEquals(statusCode, 200, String.format("Expected Status code to be 200 but was %s", statusCode));
		Assert.assertEquals(contentType, "JSON", String.format("Expected Content-Type to be JSON but was %s", contentType));
	}
}
