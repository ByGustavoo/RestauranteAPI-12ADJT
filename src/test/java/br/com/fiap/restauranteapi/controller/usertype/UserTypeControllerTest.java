package br.com.fiap.restauranteapi.controller.usertype;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTypeControllerTest extends AbstractControllerTest {

    @Test
    void getAllTest() throws Exception {
        testGet("/v1/tipousuario");
    }
}