package br.com.fiap.restauranteapi.model.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Modelo utilizado para criação de um Usuário")
public record CreateUsuarioDTO(

        @Schema(description = "Nome do usuário")
        @NotBlank(message = "O campo 'nome' é obrigatório!")
        String nome,

        @Schema(description = "E-mail do usuário")
        @NotBlank(message = "O campo 'email' é obrigatório!")
        @Email(message = "O campo 'email' deve ser um endereço de e-mail válido!")
        String email,

        @Schema(description = "Login do usuário")
        @NotBlank(message = "O campo 'login' é obrigatório!")
        @Size(min = 10, max = 20, message = "O Login deve ter entre 10 e 20 caracteres!")
        String login,

        @Schema(description = "Senha do usuário")
        @NotBlank(message = "O campo 'senha' é obrigatório!")
        @Size(min = 12, message = "A senha deve ter no mínimo 12 caracteres!")
        String senha,

        @Min(value = 1, message = "Tipo de Usuário inválido!")
        @Max(value = 2, message = "Tipo de Usuário inválido!")
        @NotNull(message = "O campo 'tipoUsuario' é obrigatório!")
        @Schema(description = "Tipo de usuário no sistema: 1 = DONO, 2 = CLIENTE", example = "1")
        Integer tipoUsuario

) {}