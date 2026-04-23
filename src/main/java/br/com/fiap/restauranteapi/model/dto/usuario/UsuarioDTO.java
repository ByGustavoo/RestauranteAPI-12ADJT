package br.com.fiap.restauranteapi.model.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Modelo utilizado para retorno dos dados do usuário")
public record UsuarioDTO(

        @Schema(description = "Identificador único do Usuário", example = "1")
        Integer id,

        @Schema(description = "Nome do Usuário", example = "João Silva")
        String nome,

        @Schema(description = "E-mail do Usuário", example = "joao@email.com")
        String email,

        @Schema(description = "Tipo de Usuário no sistema", example = "CLIENTE")
        String tipoUsuario,

        @Schema(description = "Situação do cadastro do Usuário", example = "ATIVO")
        String situacaoCadastro,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(description = "Data da última alteração do cadastro do Usuário", example = "19/04/2026")
        LocalDate dataAlteracao

) {}