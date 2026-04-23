package br.com.fiap.restauranteapi.controller.situacaocadastro;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SituacaoCadastroControllerTest extends AbstractControllerTest {

    @Test
    void getSituacaoCadastroByIdTest() throws Exception {
        testGet("/v1/situacaocadastro/1");
    }
}