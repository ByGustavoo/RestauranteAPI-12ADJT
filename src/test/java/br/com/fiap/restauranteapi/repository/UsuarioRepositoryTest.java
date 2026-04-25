package br.com.fiap.restauranteapi.repository;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
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
        var usuario = Assertions.assertDoesNotThrow(() -> usuarioRepository.findByLogin("joao"));

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.isPresent());
        Assertions.assertEquals("joao", usuario.get().getLogin());
    }

    @Test
    void findByNomeContainingIgnoreCaseTest() {
        var usuario = Assertions.assertDoesNotThrow(() -> usuarioRepository.findByNome("João Silva"));

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.isPresent());
        Assertions.assertEquals("João Silva", usuario.get().getNome());
    }

    @Test
    void existsByEmailIgnoreCaseTest() {
        Assertions.assertDoesNotThrow(() -> usuarioRepository.existsByEmailIgnoreCase("joao@email.com"));
    }
}