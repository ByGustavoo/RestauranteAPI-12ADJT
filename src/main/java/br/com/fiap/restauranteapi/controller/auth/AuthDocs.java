package br.com.fiap.restauranteapi.controller.auth;

import br.com.fiap.restauranteapi.exceptions.dto.ErrorResponseDTO;
import br.com.fiap.restauranteapi.exceptions.dto.MethodArgumentNotValidResponseDTO;
import br.com.fiap.restauranteapi.model.request.auth.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.request.auth.LoginRequest;
import br.com.fiap.restauranteapi.model.response.MensagemSucessoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Endpoints relacionados à autenticação e gerenciamento de credenciais dos Usuários")
public interface AuthDocs {

    @Operation(summary = "Realizar o login", description = "Realiza a autenticação do usuário informando login e senha válidos.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Login realizado com sucesso!",
                    content = @Content(schema = @Schema(implementation = MensagemSucessoResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos!",
                    content = @Content(schema = @Schema(implementation = MethodArgumentNotValidResponseDTO.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Senha incorreta!",
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
    @PostMapping("/login")
    ResponseEntity<MensagemSucessoResponse> login(@RequestBody @Valid LoginRequest pLoginRequest);

    @Operation(summary = "Alterar senha do usuário", description = "Permite alterar a senha do usuário informando login, senha atual e a senha nova.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Senha alterada com sucesso!",
                    content = @Content(schema = @Schema(implementation = MensagemSucessoResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos!",
                    content = @Content(schema = @Schema(implementation = MethodArgumentNotValidResponseDTO.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Senha atual incorreta!",
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
    ResponseEntity<MensagemSucessoResponse> alterarSenha(@RequestBody @Valid AlterarSenhaRequest pAlterarSenhaRequest);

}