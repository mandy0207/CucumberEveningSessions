package utils;

import io.restassured.path.json.JsonPath;

public class ParseJson {

	public static JsonPath getJsonParser(String response) {
		return new JsonPath(response);
	}
}
