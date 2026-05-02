package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.exceptions.UserNotFoundException;
import br.com.fiap.restauranteapi.model.request.auth.ChangePasswordRequest;
import br.com.fiap.restauranteapi.model.request.auth.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthServiceTest extends AbstractTest {

    @Autowired
    private AuthService authService;

    @Test
    void authenticateUserTest() {
        Assertions.assertDoesNotThrow(() -> authService.authenticateUser(new LoginRequest("joao_user01", "SenhaTeste@2026")));
    }

    @Test
    void authenticateUserLoginExceptionTest() {
        Assertions.assertThrows(UserNotFoundException.class, () -> authService.authenticateUser(new LoginRequest("loginErrado", "SenhaTeste@2026")));
    }

    @Test
    void authenticateUserPasswordExceptionTest() {
        Assertions.assertThrows(InvalidPasswordException.class, () -> authService.authenticateUser(new LoginRequest("joao_user01", "SenhaErrada@2026")));
    }

    @Test
    void changePasswordTest() {
        Assertions.assertDoesNotThrow(() -> authService.changePassword(new ChangePasswordRequest("joao_user01", "SenhaTeste@2026", "123456789@2026")));
    }

    @Test
    void changePasswordLoginExceptionTest() {
        Assertions.assertThrows(UserNotFoundException.class, () -> authService.changePassword(new ChangePasswordRequest("loginErrado", "SenhaTeste@2026", "123456789@2026")));
    }

    @Test
    void changePasswordExceptionTest() {
        Assertions.assertThrows(InvalidPasswordException.class, () -> authService.changePassword(new ChangePasswordRequest("joao_user01", "SenhaErrada@2026", "123456789@2026")));
    }
}