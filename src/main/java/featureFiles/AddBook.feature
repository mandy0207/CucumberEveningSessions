Feature: Verify Add Book Feature of API

@Smoke
Scenario: verify user is able to add single book
Given library baseURL is available
When user sends post request to add book with unique creds
Then the status code should be "200"
And response should contain message "successfully added"











