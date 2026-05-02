package br.com.fiap.restauranteapi.model.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de request para autenticação do Usuário")
public record LoginRequest(

        @NotBlank(message = "O campo 'login' é obrigatório!")
        @Size(min = 10, max = 20, message = "O Login deve ter entre 10 e 20 caracteres!")
        @Schema(description = "Login do usuário", example = "usuario123", minLength = 10, maxLength = 20)
        String login,

        @NotBlank(message = "O campo 'senha' é obrigatório!")
        @Size(min = 12, message = "A senha deve ter no mínimo 12 caracteres!")
        @Schema(description = "Senha do usuário", example = "senha@123456", minLength = 12)
        String senha

) {}