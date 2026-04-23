package br.com.fiap.restauranteapi.controller.auth;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class AuthControllerTest extends AbstractControllerTest {

    private String alterarSenhaRequest;

    @BeforeEach
    void setUp() throws IOException {
        if (alterarSenhaRequest == null) {
            alterarSenhaRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/auth/alterarSenha.json")));
        }
    }

    @Test
    void alterarSenhaTest() throws Exception {
        testPatch("/v1/auth/update-password", alterarSenhaRequest);
    }
}