package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.model.request.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.response.AlterarSenhaResponse;
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

    @Transactional
    public AlterarSenhaResponse alterarSenha(AlterarSenhaRequest pAlterarSenhaRequest) {
        var usuario = usuarioService.getUsuarioByLogin(pAlterarSenhaRequest.login());

        if (!passwordEncoder.matches(pAlterarSenhaRequest.senhaAntiga(), usuario.getSenha())) {
            throw new InvalidPasswordException();
        }

        usuario.setSenha(passwordEncoder.encode(pAlterarSenhaRequest.senhaNova()));
        return new AlterarSenhaResponse(HttpStatus.OK.value(), "Senha alterada com sucesso!");
    }
}