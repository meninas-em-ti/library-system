package com.java.study.group.librarysystem.ITtest.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.is;

public class CommonSteps {

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

    @Step("Verify that the application is UP")
    public void verifyApplicationIsUp() {
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("status", is("UP"));
    }
}
