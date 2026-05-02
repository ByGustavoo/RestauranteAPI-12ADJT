package br.com.fiap.restauranteapi.controller.auth;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class AuthControllerTest extends AbstractControllerTest {

    private String loginRequest;

    private String changePasswordRequest;

    @BeforeEach
    void setUp() throws IOException {
        if (loginRequest == null && changePasswordRequest == null) {
            loginRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/auth/loginRequest.json")));
            changePasswordRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/auth/changePasswordRequest.json")));
        }
    }

    @Test
    @Order(1)
    void loginTest() throws Exception {
        testPostStatusOk("/v1/auth/login", loginRequest);
    }

    @Test
    @Order(2)
    void changePasswordTest() throws Exception {
        testPatch("/v1/auth/alterar-senha", changePasswordRequest);
    }
}