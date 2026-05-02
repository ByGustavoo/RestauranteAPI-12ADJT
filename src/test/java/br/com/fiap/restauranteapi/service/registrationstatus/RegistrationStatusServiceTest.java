package br.com.fiap.restauranteapi.service.registrationstatus;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistrationStatusServiceTest extends AbstractTest {

    @Autowired
    private RegistrationStatusService registrationStatusService;

    @Test
    void findAllTest() {
        var situacaoCadastro = registrationStatusService.findAll();
        Assertions.assertNotNull(situacaoCadastro);
    }
}