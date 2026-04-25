package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.exceptions.DuplicateResourceException;
import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.model.dto.usuario.CreateUsuarioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class UsuarioServiceTest extends AbstractTest {

    private String usuario;

    @Autowired
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() throws IOException {
        if (usuario == null) {
            usuario = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/usuario.json")));
        }
    }

    @Test
    @Order(1)
    void getUsuarioByLoginTest() {
        var usuario = usuarioService.getUsuarioByLogin("joao");

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("joao", usuario.getLogin());
    }

    @Test
    @Order(2)
    void getUsuarioByLoginExceptionTest() {
        Assertions.assertThrows(UsuarioNotFoundException.class, () -> usuarioService.getUsuarioByLogin("loginInexistente"));
    }

    @Test
    @Order(3)
    void getUsuarioByIdTest() {
        var usuario = usuarioService.getUsuarioById(1);

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(1, usuario.id());
    }

    @Test
    @Order(4)
    void getUsuarioByIdExceptionTest() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> usuarioService.getUsuarioById(10));
    }

    @Test
    @Order(5)
    void getUsuarioByNomeTest() {
        var usuario = usuarioService.getUsuarioByNome("João Silva");

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("João Silva", usuario.nome());
    }

    @Test
    @Order(6)
    void getUsuarioByNomeSemEspacoTest() {
        var usuario = usuarioService.getUsuarioByNome("JoãoSilva");

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("João Silva", usuario.nome());
    }

    @Test
    @Order(7)
    void getUsuarioByNomeExceptionTest() {
        Assertions.assertThrows(UsuarioNotFoundException.class, () -> usuarioService.getUsuarioByNome("Nome Inexistente"));
    }

    @Test
    @Order(8)
    void salvarUsuarioTest() {

        var createUsuarioDTO = buildUsuario(
                "teste",
                "teste@email.com",
                "teste_user01",
                "senha@1234567",
                1);

        Assertions.assertThrows(DuplicateResourceException.class, () -> usuarioService.salvarUsuario(createUsuarioDTO));
    }

    @Test
    @Order(9)
    void salvarUsuarioEmailDuplicadoTest() {

        var emailDuplicado = buildUsuario(
                "joao",
                "joao@email.com",
                "joao_user01",
                "senha@123456",
                1);

        Assertions.assertThrows(DuplicateResourceException.class, () -> usuarioService.salvarUsuario(emailDuplicado));
    }

    @Test
    @Order(10)
    void salvarUsuarioLoginDuplicadoTest() {

        var loginDuplicado = buildUsuario(
                "ana",
                "ana@email.com.br",
                "ana",
                "senha@1234567",
                2);

        Assertions.assertThrows(DuplicateResourceException.class, () -> usuarioService.salvarUsuario(loginDuplicado));
    }

    private CreateUsuarioDTO buildUsuario(String nome, String email, String login, String senha, Integer tipoUsuario) {
        return new CreateUsuarioDTO(nome, email, login, senha, tipoUsuario);
    }
}