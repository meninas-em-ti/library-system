package com.java.study.group.librarysystem.ITtest.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;

public class TimetableControllerSteps {

    public Response response;

    @Step("Given a GET request to the webapp for the path {0}")
    public void makeGetRequestToApplication(final String path, String... args) {
        response = given()
                .when()
                .get(path, (Object[]) args);
    }

    @Step("A {0} response code should be provided")
    public void verifyResponseStatusCode(int statusCode) {
        response.then()
                .statusCode(statusCode);
    }

    @Step("A content type of {0} should be provided as response for the request to the path courses/timetable")
    public void verifyResponseBodyHtml(final ContentType contentTypeResponse) {
        response.then().contentType(contentTypeResponse);
    }
}
