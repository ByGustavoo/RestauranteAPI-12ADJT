package br.com.fiap.restauranteapi.model.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;


@Schema(description = "Modelo utilizado para criação de um Usuário")
public record AtualizarUsuarioRequest(


        @Schema(description = "Nome do usuário")
        String nome,

        @Schema(description = "E-mail do usuário")
        @Email(message = "O campo 'email' deve ser um endereço de e-mail válido!")
        String email,

        @Min(value = 1, message = "Valor inválido para situacaoCadastro")
        @Max(value = 1, message = "Valor inválido para situacaoCadastro")
        @Schema(description = "Situação do cadastro do usuário", example = "1")
        Integer situacaoCadastro

) {}