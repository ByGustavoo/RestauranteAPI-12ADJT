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
    void verifyPasswordTest() {
        var matches = Assertions.assertDoesNotThrow(() -> passwordService.verifyPassword("SenhaTeste@2026", "$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW"));
        Assertions.assertEquals(Boolean.TRUE, matches);
    }

    @Test
    void requestPasswordNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verifyPassword(null, "$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW"));
    }

    @Test
    void requestPasswordEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verifyPassword("", "$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW"));
    }

    @Test
    void requestEncryptPasswordNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verifyPassword("SenhaTeste@2026", null));
    }

    @Test
    void requestEncryptPasswordEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.verifyPassword("SenhaTeste@2026", ""));
    }

    @Test
    void encryptPasswordTest() {
        var senhaEncriptografada = Assertions.assertDoesNotThrow(() -> passwordService.encryptPassword("SenhaTeste@2026"));
        Assertions.assertNotNull(senhaEncriptografada);
    }

    @Test
    void encryptPasswordNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.encryptPassword(null));
    }

    @Test
    void encryptPasswordEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> passwordService.encryptPassword(""));
    }
}