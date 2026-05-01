package br.com.fiap.restauranteapi.model.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de request para solicitação de alteração de senha do Usuário")
public record ChangePasswordRequest(

        @NotBlank(message = "O campo 'login' é obrigatório!")
        @Size(min = 10, max = 20, message = "O Login deve ter entre 10 e 20 caracteres!")
        @Schema(description = "Login do usuário", example = "usuario123", minLength = 10, maxLength = 20)
        String login,

        @NotBlank(message = "O campo 'senhaAtual' é obrigatório!")
        @Size(min = 12, message = "A senha atual deve ter no mínimo 12 caracteres!")
        @Schema(description = "Senha atual do usuário", example = "senhaAtual@123", minLength = 12)
        String senhaAtual,

        @NotBlank(message = "O campo 'senhaNova' é obrigatório!")
        @Size(min = 12, message = "A nova senha deve ter no mínimo 12 caracteres!")
        @Schema(description = "Nova senha do usuário", example = "novaSenha@123", minLength = 12)
        String senhaNova

) {}