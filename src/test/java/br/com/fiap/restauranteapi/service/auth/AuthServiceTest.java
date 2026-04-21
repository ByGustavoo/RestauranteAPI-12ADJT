package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.model.request.AlterarSenhaRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthServiceTest extends AbstractTest {

    @Autowired
    private AuthService authService;

    @Test
    @Order(1)
    void alterarSenhaTest() {
        Assertions.assertDoesNotThrow(() -> authService.alterarSenha(new AlterarSenhaRequest("joao", "SenhaTeste@2026", "123456789@")));
    }

    @Test
    @Order(2)
    void alterarSenhaWithExceptionTest() {
        Assertions.assertThrows(InvalidPasswordException.class, () -> authService.alterarSenha(new AlterarSenhaRequest("joao", "SenhaErrada@2026", "123456789@")));
    }
}