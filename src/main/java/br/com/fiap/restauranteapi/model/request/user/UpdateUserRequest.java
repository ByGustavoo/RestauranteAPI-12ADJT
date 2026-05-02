package br.com.fiap.restauranteapi.model.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Modelo de request utilizado para atualizar um Usuário")
public record UpdateUserRequest(

        @Schema(description = "Nome do usuário", example = "João Silva")
        @Pattern(regexp = ".*\\S.*", message = "O campo 'nome' não pode ser vazio!")
        String nome,

        @Schema(description = "E-mail do usuário", example = "joao@email.com")
        @Email(message = "O campo 'email' deve ser um endereço de e-mail válido!")
        String email,

        @Min(value = 1, message = "Situação Cadastro inválida!")
        @Max(value = 1, message = "Situação Cadastro inválida!")
        @Schema(description = "Situação do cadastro do usuário", example = "1", minLength = 1, maxLength = 1)
        Integer situacaoCadastro

) {}