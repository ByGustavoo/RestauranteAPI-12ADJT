package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnderecoServiceTest extends AbstractTest {

    @Autowired
    private EnderecoService enderecoService;

    @Test
    void getEnderecoByIdTest() {
        var endereco = enderecoService.getEnderecoById(1);

        Assertions.assertNotNull(endereco);
        Assertions.assertEquals(1, endereco.id());
    }
}