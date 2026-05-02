package br.com.fiap.restauranteapi.controller.auth;

import br.com.fiap.restauranteapi.model.request.auth.ChangePasswordRequest;
import br.com.fiap.restauranteapi.model.request.auth.LoginRequest;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController implements AuthDocs {

    private final AuthService authService;

    @Override
    public ResponseEntity<SuccessMessageResponse> login(@RequestBody @Valid LoginRequest pLoginRequest) {
        return ResponseEntity.ok(authService.authenticateUser(pLoginRequest));
    }

    @Override
    public ResponseEntity<SuccessMessageResponse> changePassword(@RequestBody @Valid ChangePasswordRequest pChangePasswordRequest) {
        return ResponseEntity.ok(authService.changePassword(pChangePasswordRequest));
    }
}