package br.com.fiap.restauranteapi.model.request.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Modelo de request utilizado para atualizar um Usuário")
public record AtualizarUsuarioRequest(

        @Schema(description = "Nome do usuário", example = "João Silva")
        String nome,

        @Size(min = 1, message = "O campo 'email' não pode ser vazio!")
        @Schema(description = "E-mail do usuário", example = "joao@email.com")
        @Email(message = "O campo 'email' deve ser um endereço de e-mail válido!")
        String email,

        @Min(value = 1, message = "Situação Cadastro inválida!")
        @Max(value = 1, message = "Situação Cadastro inválida!")
        @Schema(description = "Situação do cadastro do usuário", example = "1")
        Integer situacaoCadastro

) {}