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

    private String alterarSenhaRequest;

    @BeforeEach
    void setUp() throws IOException {
        if (loginRequest == null && alterarSenhaRequest == null) {
            loginRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/auth/login.json")));
            alterarSenhaRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/auth/alterarSenha.json")));
        }
    }

    @Test
    @Order(1)
    void loginTest() throws Exception {
        testPost("/v1/auth/login", alterarSenhaRequest);
    }

    @Test
    @Order(2)
    void alterarSenhaTest() throws Exception {
        testPatch("/v1/auth/update-password", alterarSenhaRequest);
    }
}