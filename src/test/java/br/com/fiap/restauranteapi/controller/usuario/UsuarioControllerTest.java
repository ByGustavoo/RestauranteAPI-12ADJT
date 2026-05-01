package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class UsuarioControllerTest extends AbstractControllerTest {

    private String createUserRequest;

    private String updateUserRequest;

    private String findUserByNameRequest;

    @BeforeEach
    void setUp() throws IOException {
        if (createUserRequest == null && updateUserRequest == null && findUserByNameRequest == null) {
            createUserRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/createUserRequest.json")));
            updateUserRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/updateUserRequest.json")));
            findUserByNameRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/findUserByNameRequest.json")));
        }
    }

    @Test
    void getUsuarioByNomeTest() throws Exception {
        testPostStatusOk("/v1/usuario/buscar", findUserByNameRequest);
    }

    @Test
    void cadastrarUsuarioTest() throws Exception {
        testPost("/v1/usuario", createUserRequest);
    }

    @Test
    void atualizarUsuarioTest() throws Exception {
        testPatch("/v1/usuario/1", updateUserRequest);
    }
}