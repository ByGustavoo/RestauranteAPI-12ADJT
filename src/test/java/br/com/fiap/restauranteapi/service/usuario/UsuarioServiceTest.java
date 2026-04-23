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
    void getUsuarioByIdTest(){
        var usuario = usuarioService.getUsuarioById(1);

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(1, usuario.id());
    }

    @Test
    @Order(3)
    void getUsuarioByNomeIgnoreCaseTest() {
        var usuario = usuarioService.getUsuarioByName(" joão silva ");

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("João Silva", usuario.nome());
    }

    @Test
    @Order(4)
    void getUsuarioByNomeSemEspacoTest() {
        var usuario = usuarioService.getUsuarioByName("JoãoSilva");
        
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("João Silva", usuario.nome());
    }

    @Test
    @Order(5)
    void getUsuarioByLoginWithExceptionTest() {
        Assertions.assertThrows(LoginNotFoundException.class, () -> usuarioService.getUsuarioByLogin("loginInexistente"));
    }
}