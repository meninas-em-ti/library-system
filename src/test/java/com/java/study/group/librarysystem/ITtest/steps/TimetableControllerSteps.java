package com.java.study.group.librarysystem.ITtest.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;


public class TimetableControllerSteps {

    @Step("A content type of {1} should be provided as response for the request to the path courses/timetable")
    public void verifyResponseBodyHtml(final Response response, final ContentType contentTypeResponse) {
        response.then().contentType(contentTypeResponse);
    }
}
