package br.com.fiap.restauranteapi.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para solicitação de alteração de senha")
public record AlterarSenhaRequest(

        @NotBlank(message = "O Login é obrigatório!")
        @Schema(description = "Login do usuário", example = "usuario123")
        String login,

        @NotBlank(message = "A senha atual é obrigatória!")
        @Schema(description = "Senha atual do usuário", example = "senhaAntiga123")
        String senhaAntiga,

        @NotBlank(message = "A nova senha é obrigatória!")
        @Size(min = 10, message = "A nova senha deve ter no mínimo 10 caracteres!")
        @Schema(description = "Nova senha do usuário", example = "novaSenha@123", minLength = 10)
        String senhaNova

) {}