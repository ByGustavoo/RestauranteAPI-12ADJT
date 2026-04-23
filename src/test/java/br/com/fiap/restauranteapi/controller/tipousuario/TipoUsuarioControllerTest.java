package br.com.fiap.restauranteapi.controller.tipousuario;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TipoUsuarioControllerTest extends AbstractControllerTest {

    @Test
    void getTipoUsuarioByIdTest() throws Exception {
        testGet("/v1/tipousuario/1");
    }
}