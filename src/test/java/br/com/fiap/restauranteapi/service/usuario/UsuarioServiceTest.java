package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.model.request.usuario.BuscarUsuarioRequest;
import br.com.fiap.restauranteapi.model.request.usuario.CriarUsuarioRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class UsuarioServiceTest extends AbstractTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void getUsuarioByLoginTest() {
        var usuario = usuarioService.getUsuarioByLogin("joao_user01");

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("joao_user01", usuario.getLogin());
    }

    @Test
    void getUsuarioByLoginExceptionTest() {
        Assertions.assertThrows(UsuarioNotFoundException.class, () -> usuarioService.getUsuarioByLogin("loginInexistente"));
    }

    @Test
    void getUsuarioByNomeTest() {
        var usuario = usuarioService.getUsuarioByNome(new BuscarUsuarioRequest("João Silva"));

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("João Silva", usuario.nome());
    }

    @Test
    void getUsuarioByNomeExceptionTest() {
        Assertions.assertThrows(UsuarioNotFoundException.class, () -> usuarioService.getUsuarioByNome(new BuscarUsuarioRequest("Nome Inexistente")));
    }

    @Test
    void salvarUsuarioTest() {

        var createUsuarioDTO = buildUsuario(
                "teste",
                "teste@email.com",
                "teste_user01",
                "senha@1234567",
                1);

        Assertions.assertDoesNotThrow(() -> usuarioService.salvarUsuario(createUsuarioDTO));
    }

    @Test
    void salvarUsuarioEmailDuplicadoTest() {

        var emailDuplicado = buildUsuario(
                "joao",
                "joao@email.com",
                "joao__user01",
                "senha@123456",
                1);

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> usuarioService.salvarUsuario(emailDuplicado));
    }

    @Test
    void salvarUsuarioLoginDuplicadoTest() {

        var loginDuplicado = buildUsuario(
                "ana",
                "ana@email.com.br",
                "ana_user01",
                "senha@1234567",
                2);

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> usuarioService.salvarUsuario(loginDuplicado));
    }

    private CriarUsuarioRequest buildUsuario(String nome, String email, String login, String senha, Integer tipoUsuario) {
        return new CriarUsuarioRequest(nome, email, login, senha, tipoUsuario);
    }
}