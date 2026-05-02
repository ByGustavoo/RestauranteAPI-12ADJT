package br.com.fiap.restauranteapi.model.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Modelo de resposta com os dados de Usuário")
public record UserDTO(

        @Schema(description = "Identificador único do usuário")
        Integer id,

        @Schema(description = "Nome do usuário")
        String nome,

        @Schema(description = "E-mail do usuário")
        String email,

        @Schema(description = "Login do usuário")
        String login,

        @Schema(description = "Tipo de usuário no sistema")
        String tipoUsuario,

        @Schema(description = "Situação do cadastro do usuário")
        String situacaoCadastro,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(description = "Data da última alteração do cadastro do usuário")
        LocalDate dataAlteracao

) {}