package br.com.fiap.restauranteapi.service.user;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.exceptions.UserNotFoundException;
import br.com.fiap.restauranteapi.model.request.user.CreateUserRequest;
import br.com.fiap.restauranteapi.model.request.user.findUserByNameRequest;
import br.com.fiap.restauranteapi.model.request.user.UpdateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class UserServiceTest extends AbstractTest {

    @Autowired
    private UserService userService;

    @Test
    void findUserByLoginTest() {
        var user = userService.findUserByLogin("joao_user01");

        Assertions.assertNotNull(user);
        Assertions.assertEquals("joao_user01", user.getLogin());
    }

    @Test
    void findUserByLoginExceptionTest() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.findUserByLogin("loginInexistente"));
    }

    @Test
    void findUserByNameTest() {
        var usuario = userService.findUserByName(new findUserByNameRequest("João Silva"));

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("João Silva", usuario.nome());
    }

    @Test
    void findUserByNameExceptionTest() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.findUserByName(new findUserByNameRequest("Nome Inexistente")));
    }

    @Test
    void saveUserTest() {

        var createUsuarioRequest = new CreateUserRequest(
                "teste",
                "teste@email.com",
                "teste_user01",
                "senha@1234567",
                1);

        Assertions.assertDoesNotThrow(() -> userService.saveUser(createUsuarioRequest));
    }

    @Test
    void saveUserWithDuplicateEmailTest() {

        var emailDuplicado = new CreateUserRequest(
                "joao",
                "joao@email.com",
                "joao__user01",
                "senha@123456",
                1);

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userService.saveUser(emailDuplicado));
    }

    @Test
    void saveUserWithDuplicateLoginTest() {

        var loginDuplicado = new CreateUserRequest(
                "ana",
                "ana@email.com.br",
                "ana_user01",
                "senha@1234567",
                2);

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userService.saveUser(loginDuplicado));
    }

    @Test
    void updateUserTest() {

        var updateUserRequest = new UpdateUserRequest(
                "João Silva Atualizado",
                "joao.atualizado@email.com",
                1
        );

        Assertions.assertDoesNotThrow(() -> userService.updateUser(1, updateUserRequest));
    }
}