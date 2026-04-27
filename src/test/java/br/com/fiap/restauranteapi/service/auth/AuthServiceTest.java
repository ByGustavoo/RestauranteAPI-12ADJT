package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.model.request.auth.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.request.auth.LoginRequest;
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
    void autenticarUsuarioTest() {
        Assertions.assertDoesNotThrow(() -> authService.autenticarUsuario(new LoginRequest("joao_user01", "SenhaTeste@2026")));
    }

    @Test
    @Order(2)
    void autenticarUsuarioLoginExceptionTest() {
        Assertions.assertThrows(UsuarioNotFoundException.class, () -> authService.autenticarUsuario(new LoginRequest("loginErrado", "SenhaTeste@2026")));
    }

    @Test
    @Order(3)
    void autenticarUsuarioSenhaExceptionTest() {
        Assertions.assertThrows(InvalidPasswordException.class, () -> authService.autenticarUsuario(new LoginRequest("joao_user01", "SenhaErrada@2026")));
    }

    @Test
    @Order(4)
    void alterarSenhaTest() {
        Assertions.assertDoesNotThrow(() -> authService.alterarSenha(new AlterarSenhaRequest("joao_user01", "SenhaTeste@2026", "123456789@2026")));
    }

    @Test
    @Order(5)
    void alterarSenhaLoginExceptionTest() {
        Assertions.assertThrows(UsuarioNotFoundException.class, () -> authService.alterarSenha(new AlterarSenhaRequest("loginErrado", "SenhaTeste@2026", "123456789@2026")));
    }

    @Test
    @Order(6)
    void alterarSenhaSenhaExceptionTest() {
        Assertions.assertThrows(InvalidPasswordException.class, () -> authService.alterarSenha(new AlterarSenhaRequest("joao_user01", "SenhaErrada@2026", "123456789@2026")));
    }
}