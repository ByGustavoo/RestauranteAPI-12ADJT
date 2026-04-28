package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.exceptions.dto.ErrorResponseDTO;
import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Endereço", description = "Endpoints relacionados aos Endereços dos Usuários")
public interface EnderecoDocs {

    @Operation(summary = "Listar endereços dos usuários", description = "Retorna uma lista de endereços vinculados aos usuários cadastrados no sistema.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de endereços dos usuários retornada com sucesso!"),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping
    ResponseEntity<PageResponse<EnderecoDTO>> getAll(@Parameter(hidden = true) @PageableDefault(size = 100, sort = "id") Pageable pageable);

}