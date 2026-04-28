package br.com.fiap.restauranteapi.model.request.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Modelo de request para criação de um Usuário")
public record CriarUsuarioRequest(

        @NotBlank(message = "O campo 'nome' é obrigatório!")
        @Schema(description = "Nome do usuário", example = "João Silva")
        String nome,

        @NotBlank(message = "O campo 'email' é obrigatório!")
        @Schema(description = "E-mail do usuário", example = "joao@email.com")
        @Email(message = "O campo 'email' deve ser um endereço de e-mail válido!")
        String email,

        @NotBlank(message = "O campo 'login' é obrigatório!")
        @Schema(description = "Login do usuário", example = "joaosilva123")
        @Size(min = 10, max = 20, message = "O Login deve ter entre 10 e 20 caracteres!")
        String login,

        @NotBlank(message = "O campo 'senha' é obrigatório!")
        @Schema(description = "Senha do usuário", example = "senhaSegura123!")
        @Size(min = 12, message = "A senha deve ter no mínimo 12 caracteres!")
        String senha,

        @Min(value = 1, message = "Tipo de Usuário inválido!")
        @Max(value = 2, message = "Tipo de Usuário inválido!")
        @NotNull(message = "O campo 'tipoUsuario' é obrigatório!")
        @Schema(description = "Tipo de usuário no sistema: 1 = DONO, 2 = CLIENTE", example = "1")
        Integer tipoUsuario

) {}