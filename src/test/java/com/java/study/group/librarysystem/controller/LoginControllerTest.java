package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.LoginDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private Model modelMock;
    private LoginController loginController;
    private final LoginDto loginDto = new LoginDto();

    @BeforeEach
    void setUp() {
        loginController = new LoginController();
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(modelMock);
    }

    @Test
    void performLoginWithValidCredentials() {
        loginDto.setUsername("Admin");
        loginDto.setPassword("Admin@123");

        String result = loginController.performLogin(loginDto, modelMock);

        assertEquals("welcome", result);
    }

    @Test
    void performLoginWithInvalidCredentials() {
        loginDto.setUsername("InvalidUser");
        loginDto.setPassword("InvalidPassword");

        String result = loginController.performLogin(loginDto, modelMock);

        assertEquals("login", result);
        verify(modelMock).addAttribute("error", "Incorrect Username & Password");
    }
}