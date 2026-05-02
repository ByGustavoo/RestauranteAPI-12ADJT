package br.com.fiap.restauranteapi.controller.address;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class AddressControllerTest extends AbstractControllerTest {

    private String createAddressRequest;

    private String updateAddressRequest;

    @BeforeEach
    void setUp() throws IOException {
        if (createAddressRequest == null && updateAddressRequest == null) {
            createAddressRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/endereco/createAddressRequest.json")));
            updateAddressRequest = new String(Files.readAllBytes(Paths.get("src/test/resources/endereco/updateAddressRequest.json")));
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
    void updateAddressByIdTest() throws Exception {
        testPatch("/v1/endereco/1", updateAddressRequest);
    }

    @Test
    void deleteAddressByIdTest() throws Exception {
        testDelete("/v1/endereco/1");
    }
}