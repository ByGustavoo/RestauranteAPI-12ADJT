package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class EnderecoControllerTest extends AbstractControllerTest {

    private String createAddressRequest;

    @BeforeEach
    void setUp() throws IOException {
        if (createAddressRequest == null) {
            createAddressRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/endereco/createAddressRequest.json")));
        }
    }

    @Test
    void getAllTest() throws Exception {
        testGet("/v1/endereco");
    }

    @Test
    void saveAddressTest() throws Exception {
        testPost("/v1/endereco", createAddressRequest);
    }

    @Test
    void deleteAddressByIdTest() throws Exception {
        testDelete("/v1/endereco/1");
    }
}