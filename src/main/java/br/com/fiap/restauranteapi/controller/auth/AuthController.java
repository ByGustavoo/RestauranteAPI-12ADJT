package br.com.fiap.restauranteapi.controller.auth;

import br.com.fiap.restauranteapi.exceptions.dto.ErrorResponseDTO;
import br.com.fiap.restauranteapi.model.request.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.response.AlterarSenhaResponse;
import br.com.fiap.restauranteapi.service.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Tag(name = "Auth", description = "Endpoints relacionados à autenticação e gerenciamento de credenciais")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "Alterar senha do usuário", description = "Permite alterar a senha do usuário informando login, senha atual e nova senha.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Senha alterada com sucesso!",
                    content = @Content(schema = @Schema(implementation = AlterarSenhaResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos ou senha atual incorreta!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PatchMapping("/update-password")
    public ResponseEntity<AlterarSenhaResponse> alterarSenha(@RequestBody @Valid AlterarSenhaRequest pAlterarSenhaRequest) {
        return ResponseEntity.ok(authService.alterarSenha(pAlterarSenhaRequest));
    }
}