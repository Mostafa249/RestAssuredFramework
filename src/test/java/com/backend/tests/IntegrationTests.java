package com.backend.tests;

import com.backend.endpoints.ApiConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class IntegrationTests extends BaseTest {
    @Test(priority = 1)
    public void testGetBookingAuth() {
        Response response = RestAssured.
                given().spec(respSpec).
                when().
                body(requestPayloads.getBookingTokenPayload()).
                post(ApiConstants.getBookingAuth);
        assertActions.verifyCreationStatusCode(response);
        System.out.println
                ("Your token is : " + response.then()
                        .extract().path("token").toString());
    }

    @Test(priority = 2)
    public void testCreateNewBooking() {
        requestPayloads.setFirstName("Mostafa");
        Response response = RestAssured.
                given().spec(respSpec).
                when().
                body(requestPayloads.getCreateNewBookingPayload()).
                post(ApiConstants.createNewBookingApi);
        assertActions.verifyCreationStatusCode(response);
        assertActions.verifyResponseBody(
                requestPayloads.getFirstName(), response.then().extract()
                        .path("booking.firstname").toString(), "");

    }

    @Test(priority = 3)
    public void testGetBookingIds() {
        Response response = RestAssured.
                given().spec(respSpec).
                when().
                body(requestPayloads.getCreateNewBookingPayload()).
                get(ApiConstants.getBookingIds);
        assertActions.verifyCreationStatusCode(response);
        System.out.println(response.then().extract().
                path("bookingid[1]").toString());
    }
}
