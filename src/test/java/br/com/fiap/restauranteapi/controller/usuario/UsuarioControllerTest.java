package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuarioControllerTest extends AbstractControllerTest {

    @Test
    void getUsuarioByIdTest() throws Exception {
        testGet("/v1/usuario/1");
    }

    @Test
    void getUsuarioByNomeTest() throws Exception {
        testGet("/v1/usuario?nome=João Silva");
    }
}