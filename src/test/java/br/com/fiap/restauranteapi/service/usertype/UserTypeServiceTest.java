package br.com.fiap.restauranteapi.service.usertype;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserTypeServiceTest extends AbstractTest {

    @Autowired
    private UserTypeService userTypeService;

    @Test
    void findAllTest() {
        var tipoUsuario = userTypeService.findAll();
        assertNotNull(tipoUsuario);
    }
}