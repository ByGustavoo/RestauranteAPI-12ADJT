package br.com.fiap.restauranteapi.model.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "Modelo utilizado para criação de um Usuário")
public record UpdateUserDTO(


        @Schema(description = "Nome do usuário")
        String nome,

        @Schema(description = "E-mail do usuário")
        @Email(message = "O campo 'email' deve ser um endereço de e-mail válido!")
        String email,

        @Schema(description = "Situação do cadastro do usuário", example = "ATIVO")
        Integer situacaoCadastro

) {}