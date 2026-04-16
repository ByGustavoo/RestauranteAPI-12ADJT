package br.com.fiap.restauranteapi.service.auth;

import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.model.request.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.response.AlterarSenhaResponse;
import br.com.fiap.restauranteapi.service.usuario.UsuarioService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public AlterarSenhaResponse alterarSenha(AlterarSenhaRequest pAlterarSenhaRequest) {
        var usuario = usuarioService.getUsuarioByLogin(pAlterarSenhaRequest.login());

        if (!passwordEncoder.matches(pAlterarSenhaRequest.senhaAntiga(), usuario.getSenha())) {
            throw new InvalidPasswordException();
        }

        usuario.setSenha(passwordEncoder.encode(pAlterarSenhaRequest.senhaNova()));
        return new AlterarSenhaResponse(HttpStatus.OK.value(), "Senha alterada com sucesso!");
    }

    public String gerarSenha(@NotBlank String senha) {
        return passwordEncoder.encode(senha);
    }
}