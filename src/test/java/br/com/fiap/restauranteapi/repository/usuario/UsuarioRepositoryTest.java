package br.com.fiap.restauranteapi.repository.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuarioRepositoryTest extends AbstractTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void findByLoginTest() {
        var usuario = Assertions.assertDoesNotThrow(() -> usuarioRepository.findByLogin("joao_user01"));

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.isPresent());
        Assertions.assertEquals("joao_user01", usuario.get().getLogin());
    }

    @Test
    void findByNomeTest() {
        var usuario = Assertions.assertDoesNotThrow(() -> usuarioRepository.findByNome("João Silva"));

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.isPresent());
        Assertions.assertEquals("João Silva", usuario.get().getNome());
    }

    @Test
    void existsByEmailIgnoreCaseTest() {
        var emailExistente = Assertions.assertDoesNotThrow(() -> usuarioRepository.existsByEmailIgnoreCase("joao@email.com"));
        var emailInexistente = Assertions.assertDoesNotThrow(() -> usuarioRepository.existsByEmailIgnoreCase("inexistente@email.com"));

        Assertions.assertEquals(Boolean.TRUE, emailExistente);
        Assertions.assertNotEquals(Boolean.TRUE, emailInexistente);
    }

    @Test
    void existsByLoginIgnoreCaseTest() {
        var loginExistente = Assertions.assertDoesNotThrow(() -> usuarioRepository.existsByLoginIgnoreCase("joao_user01"));
        var loginInexistente = Assertions.assertDoesNotThrow(() -> usuarioRepository.existsByLoginIgnoreCase("inexistente_user"));

        Assertions.assertEquals(Boolean.TRUE, loginExistente);
        Assertions.assertNotEquals(Boolean.TRUE, loginInexistente);
    }
}