package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuildersUtil {

	public static RequestSpecification makeRequestSpec(String baseURl, ContentType content) {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseURl).setContentType(content)
				.build().log().all();
		return req;
	}

	public static ResponseSpecification makeResponseSpec(ContentType content) {

		ResponseSpecification res = new ResponseSpecBuilder().expectContentType(content).
				build();
		return res;
	}
}
