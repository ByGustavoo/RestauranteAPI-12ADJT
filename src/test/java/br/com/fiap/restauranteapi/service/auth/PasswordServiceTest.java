package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordServiceTest extends AbstractTest {

    @Autowired
    private PasswordService passwordService;

    @Test
    void verificarSenhaTest() {
        var matches = Assertions.assertDoesNotThrow(() -> passwordService.verificarSenha("SenhaTeste@2026", "$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW"));
        Assertions.assertEquals(Boolean.TRUE, matches);
    }

    @Test
    void requestSenhaNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verificarSenha(null, "$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW"));
    }

    @Test
    void requestSenhaEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verificarSenha("", "$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW"));
    }

    @Test
    void requestSenhaCriptografadaNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verificarSenha("SenhaTeste@2026", null));
    }

    @Test
    void requestSenhaCriptografadaEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verificarSenha("SenhaTeste@2026", ""));
    }

    @Test
    void encriptografarSenhaTest() {
        var senhaEncriptografada = Assertions.assertDoesNotThrow(() -> passwordService.encriptografarSenha("SenhaTeste@2026"));
        Assertions.assertNotNull(senhaEncriptografada);
    }

    @Test
    void encriptografarSenhaNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.encriptografarSenha(null));
    }

    @Test
    void encriptografarSenhaEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.encriptografarSenha(""));
    }
}