package payLoad;

public class Payload {

	public static String getBookPayload(String isbn, String aisle) {
		return "\r\n" + "{\r\n" + "\"name\":\"Rest Assured\",\r\n" + "\"isbn\":\"" + isbn + "\",\r\n" + "\"aisle\":\""
				+ aisle + "\",\r\n" + "\"author\":\"Nick Ryan\"\r\n" + "}\r\n" + "";
	}

	public static String getDeleteBookPayload(String bookID) {
		return "{\r\n" + "			\"ID\" : \"" + bookID + "\"\r\n" + "			}";

	}
	
	
}
