package com.backend.tests;

import com.backend.actions.ApiActions;
import com.backend.actions.AssertActions;
import com.backend.payloads.RequestPayloads;
import com.backend.utils.DataUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected RequestSpecBuilder builder;
    protected RequestSpecification respSpec ;
    protected RequestPayloads requestPayloads = new RequestPayloads();
    protected AssertActions assertActions = new AssertActions();
    protected ApiActions apiActions = new ApiActions();

    @BeforeMethod
    protected void setupRequestConfiguration() {
        builder =  new RequestSpecBuilder().
                setBaseUri(DataUtils.getDataFromTestDataFile(
                        "Booking", "BaseUrl", "Value")).
                addHeader("Content-Type",
                        DataUtils.getDataFromTestDataFile
                                ("Booking", "Header", "Value"));
        respSpec = builder.build();
    }
}