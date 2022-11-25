package com.java.study.group.librarysystem.ITtest;

import com.java.study.group.librarysystem.ITtest.steps.CommonSteps;
import com.java.study.group.librarysystem.LibrarySystemApplication;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import javax.annotation.PostConstruct;

@ExtendWith(SerenityJUnit5Extension.class)
@SpringBootTest(classes = LibrarySystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthIT {

    @Steps
    private CommonSteps commonSteps;

    @LocalServerPort
    private int port;

    @PostConstruct
    public void setDefaultPort() {
        SerenityRest.setDefaultPort(port);
    }


    @Test
    void healthCheck() {
        commonSteps.makeGetRequestToApplication("actuator/health");
        commonSteps.verifyResponseStatusCode(HttpStatus.SC_OK);
        commonSteps.verifyApplicationIsUp();
    }
}
