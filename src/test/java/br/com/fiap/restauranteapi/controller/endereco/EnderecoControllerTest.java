package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnderecoControllerTest extends AbstractControllerTest {

    @Test
    void getEnderecoByIdTest() throws Exception {
        testGet("/v1/endereco/1");
    }
}