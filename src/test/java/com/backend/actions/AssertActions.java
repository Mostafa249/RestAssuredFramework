package com.backend.actions;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertActions {
    public  void verifyCreationStatusCode(Response res){
        Assert.assertEquals(res.getStatusCode(),200);
    }
    public  void verifyResponseBody(String expected , String actual , String desc){
        Assert.assertEquals(actual,expected,desc);
    }
}
