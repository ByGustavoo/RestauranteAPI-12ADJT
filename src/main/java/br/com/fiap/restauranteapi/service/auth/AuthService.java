package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.model.request.auth.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.request.auth.LoginRequest;
import br.com.fiap.restauranteapi.model.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioService usuarioService;

    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public MensagemSucessoResponse autenticarUsuario(LoginRequest pLoginRequest) {
        var usuario = getUsuarioByLogin(pLoginRequest.login());

        if (!passwordEncoder.matches(pLoginRequest.senha(), usuario.getSenha())) {
            throw new InvalidPasswordException("A senha informada está incorreta! Por favor, verifique e tente novamente.");
        }

        return new MensagemSucessoResponse(HttpStatus.OK.value(), "Login realizado com sucesso! Seja bem-vindo ao nosso sistema.");
    }

    @Transactional
    public MensagemSucessoResponse alterarSenha(AlterarSenhaRequest pAlterarSenhaRequest) {
        var usuario = getUsuarioByLogin(pAlterarSenhaRequest.login());

        if (!passwordEncoder.matches(pAlterarSenhaRequest.senhaAtual(), usuario.getSenha())) {
            throw new InvalidPasswordException("Não foi possível alterar a senha, a senha atual informada está incorreta!");
        }

        usuario.setSenha(passwordEncoder.encode(pAlterarSenhaRequest.senhaNova()));
        return new MensagemSucessoResponse(HttpStatus.OK.value(), "Senha alterada com sucesso!");
    }

    public String encriptografarSenha(String pSenha) {
        if (pSenha == null || pSenha.isBlank()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia!");
        }

        return passwordEncoder.encode(pSenha);
    }

    private Usuario getUsuarioByLogin(String pLogin) {
        return usuarioService.getUsuarioByLogin(pLogin);
    }
}