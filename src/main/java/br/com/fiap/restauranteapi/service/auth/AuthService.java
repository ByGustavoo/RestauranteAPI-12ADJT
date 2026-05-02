package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.model.entity.user.User;
import br.com.fiap.restauranteapi.model.request.auth.ChangePasswordRequest;
import br.com.fiap.restauranteapi.model.request.auth.LoginRequest;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    private final PasswordService passwordService;

    @Transactional(readOnly = true)
    public SuccessMessageResponse authenticateUser(LoginRequest pLoginRequest) {
        var user = getUserByLogin(pLoginRequest.login());

        if (!passwordService.verifyPassword(pLoginRequest.senha(), user.getSenha())) {
            throw new InvalidPasswordException("A senha informada está incorreta! Por favor, verifique e tente novamente.");
        }

        return new SuccessMessageResponse(HttpStatus.OK.value(), "Login realizado com sucesso! Seja bem-vindo ao nosso sistema.");
    }

    @Transactional
    public SuccessMessageResponse changePassword(ChangePasswordRequest pChangePasswordRequest) {
        var usuario = getUserByLogin(pChangePasswordRequest.login());

        if (!passwordService.verifyPassword(pChangePasswordRequest.senhaAtual(), usuario.getSenha())) {
            throw new InvalidPasswordException("Não foi possível alterar a senha, a senha atual informada está incorreta!");
        }

        usuario.setSenha(passwordService.encryptPassword(pChangePasswordRequest.senhaNova()));
        return new SuccessMessageResponse(HttpStatus.OK.value(), "Senha alterada com sucesso!");
    }

    private User getUserByLogin(String pLogin) {
        return userService.findUserByLogin(pLogin);
    }
}