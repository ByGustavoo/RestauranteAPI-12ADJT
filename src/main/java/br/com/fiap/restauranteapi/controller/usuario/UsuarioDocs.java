package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.exceptions.dto.ErrorResponseDTO;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Usuário", description = "Endpoints relacionados ao gerenciamento de usuários")
public interface UsuarioDocs {

    @Operation(summary = "Buscar usuário por nome", description = "Retorna os dados de um usuário a partir do nome informado como parâmetro na URL.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário encontrado com sucesso!",
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Parâmetro nome inválido ou não informado!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping(params = "nome")
    ResponseEntity<UsuarioDTO> getUsuarioByNome(@Parameter(description = "Nome do usuário para consulta.", example = "João Silva", required = true) @RequestParam @NotBlank String nome);

}