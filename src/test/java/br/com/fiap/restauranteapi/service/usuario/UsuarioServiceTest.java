package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.exceptions.LoginNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuarioServiceTest extends AbstractTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    @Order(1)
    void getUsuarioByLoginTest() {
        var usuario = usuarioService.getUsuarioByLogin("joao");
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("joao", usuario.getLogin());
    }

    @Test
    @Order(2)
    void getUsuarioByLoginWithExceptionTest() {
        Assertions.assertThrows(LoginNotFoundException.class, () -> usuarioService.getUsuarioByLogin("loginInexistente"));
    }
}