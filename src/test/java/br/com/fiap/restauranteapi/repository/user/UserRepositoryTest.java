package br.com.fiap.restauranteapi.repository.user;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest extends AbstractTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByLoginTest() {
        var user = Assertions.assertDoesNotThrow(() -> userRepository.findByLogin("joao_user01"));

        Assertions.assertNotNull(user);
        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals("joao_user01", user.get().getLogin());
    }

    @Test
    void findByNomeTest() {
        var user = Assertions.assertDoesNotThrow(() -> userRepository.findByNome("João Silva"));

        Assertions.assertNotNull(user);
        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals("João Silva", user.get().getNome());
    }

    @Test
    void existsByEmailIgnoreCaseTest() {
        var emailExists = Assertions.assertDoesNotThrow(() -> userRepository.existsByEmailIgnoreCase("joao@email.com"));
        var emailNotExists = Assertions.assertDoesNotThrow(() -> userRepository.existsByEmailIgnoreCase("inexistente@email.com"));

        Assertions.assertEquals(Boolean.TRUE, emailExists);
        Assertions.assertNotEquals(Boolean.TRUE, emailNotExists);
    }

    @Test
    void existsByLoginIgnoreCaseTest() {
        var loginExists = Assertions.assertDoesNotThrow(() -> userRepository.existsByLoginIgnoreCase("joao_user01"));
        var loginNotExists = Assertions.assertDoesNotThrow(() -> userRepository.existsByLoginIgnoreCase("inexistente_user"));

        Assertions.assertEquals(Boolean.TRUE, loginExists);
        Assertions.assertNotEquals(Boolean.TRUE, loginNotExists);
    }
}