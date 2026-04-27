package br.com.fiap.restauranteapi.model.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de request para solicitação de alteração de senha do Usuário")
public record AlterarSenhaRequest(

        @NotBlank(message = "O campo 'login' é obrigatório!")
        @Schema(description = "Login do usuário", example = "usuario123")
        @Size(min = 10, max = 20, message = "O Login deve ter entre 10 e 20 caracteres!")
        String login,

        @NotBlank(message = "O campo 'senhaAtual' é obrigatório!")
        @Schema(description = "Senha atual do usuário", example = "senhaAtual@123")
        @Size(min = 12, message = "A senha atual deve ter no mínimo 12 caracteres!")
        String senhaAtual,

        @NotBlank(message = "O campo 'senhaNova' é obrigatório!")
        @Schema(description = "Nova senha do usuário", example = "novaSenha@123")
        @Size(min = 12, message = "A nova senha deve ter no mínimo 12 caracteres!")
        String senhaNova

) {}