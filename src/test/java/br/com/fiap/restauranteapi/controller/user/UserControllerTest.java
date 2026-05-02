package br.com.fiap.restauranteapi.controller.user;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class UserControllerTest extends AbstractControllerTest {

    private String createUserRequest;

    private String updateUserRequest;

    private String searchUserByNameRequest;

    @BeforeEach
    void setUp() throws IOException {
        if (createUserRequest == null && updateUserRequest == null && searchUserByNameRequest == null) {
            createUserRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/createUserRequest.json")));
            updateUserRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/updateUserRequest.json")));
            searchUserByNameRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/searchUserByNameRequest.json")));
        }
    }

    @Test
    void getUserByNameTest() throws Exception {
        testPostStatusOk("/v1/usuario/buscar", searchUserByNameRequest);
    }

    @Test
    void createUserTest() throws Exception {
        testPost("/v1/usuario", createUserRequest);
    }

    @Test
    void updateUserByIdTest() throws Exception {
        testPatch("/v1/usuario/1", updateUserRequest);
    }

    @Test
    void deleteUserByIdTest() throws Exception {
        testDelete("/v1/usuario/1");
    }
}