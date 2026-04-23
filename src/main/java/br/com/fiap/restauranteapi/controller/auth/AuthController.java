package br.com.fiap.restauranteapi.controller.auth;

import br.com.fiap.restauranteapi.model.request.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.response.AlterarSenhaResponse;
import br.com.fiap.restauranteapi.service.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController implements AuthDocs {

    @Autowired
    private AuthService authService;

    @Override
    public ResponseEntity<AlterarSenhaResponse> alterarSenha(@RequestBody @Valid AlterarSenhaRequest pAlterarSenhaRequest) {
        return ResponseEntity.ok(authService.alterarSenha(pAlterarSenhaRequest));
    }
}