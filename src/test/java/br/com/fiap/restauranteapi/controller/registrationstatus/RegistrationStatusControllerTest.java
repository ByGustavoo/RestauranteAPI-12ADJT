package br.com.fiap.restauranteapi.controller.registrationstatus;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistrationStatusControllerTest extends AbstractControllerTest {

    @Test
    void getAllTest() throws Exception {
        testGet("/v1/situacaocadastro");
    }
}