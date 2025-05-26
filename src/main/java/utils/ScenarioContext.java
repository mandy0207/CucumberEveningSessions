package utils;

import io.restassured.response.Response;

public class ScenarioContext {

	private Response response;
	private String bookID;
	
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	
}
