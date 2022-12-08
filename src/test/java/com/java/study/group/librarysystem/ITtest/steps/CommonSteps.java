package com.java.study.group.librarysystem.ITtest.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.is;

public class CommonSteps {

    @Step("Given a GET request to the webapp for the path {0}")
    public Response makeGetRequestToApplication(final String path, String... args) {
        return given()
                .when()
                .get(path, (Object[]) args);
    }
    @Step("A {1} response code should be provided")
    public void verifyResponseStatusCode(final Response response, final int statusCode) {
        response.then()
                .statusCode(statusCode);
    }

    @Step("Verify that the application is UP")
    public void verifyApplicationIsUp(final Response response) {
        response.then()
                .body("status", is("UP"));
    }
}
