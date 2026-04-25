package br.com.fiap.restauranteapi.model.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Modelo utilizado para retorno dos dados de Usuário")
public record UsuarioDTO(

        @Schema(description = "Identificador único do usuário", example = "1")
        Integer id,

        @Schema(description = "Nome do usuário", example = "João Silva")
        String nome,

        @Schema(description = "E-mail do usuário", example = "joao@email.com")
        String email,

        @Schema(description = "Login do usuário", example = "joao_silva")
        String login,

        @Schema(description = "Tipo de usuário no sistema", example = "CLIENTE")
        String tipoUsuario,

        @Schema(description = "Situação do cadastro do usuário", example = "ATIVO")
        String situacaoCadastro,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(description = "Data da última alteração do cadastro do usuário", example = "19/04/2026")
        LocalDate dataAlteracao

) {}