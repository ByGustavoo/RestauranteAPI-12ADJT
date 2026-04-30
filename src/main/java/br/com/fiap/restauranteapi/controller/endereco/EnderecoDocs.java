package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.exceptions.dto.ErrorResponseDTO;
import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.model.request.endereco.CriarEnderecoRequest;
import br.com.fiap.restauranteapi.model.request.endereco.UpdateAddressRequest;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import br.com.fiap.restauranteapi.model.response.success.MensagemSucessoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "Cadastrar um endereço", description = "Realiza o cadastro de um novo endereço no sistema com base nos dados informados no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Endereço cadastrado com sucesso!",
                    content = @Content(schema = @Schema(implementation = MensagemSucessoResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos na requisição!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping
    ResponseEntity<MensagemSucessoResponse> saveAddress(@RequestBody @Valid CriarEnderecoRequest criarEnderecoRequest);

    @Operation(summary = "Atualizar um endereço", description = "Atualiza parcialmente um endereço existente com base no ID informado na URL e nos dados enviados no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Endereço atualizado com sucesso!",
                    content = @Content(schema = @Schema(implementation = MensagemSucessoResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos na requisição!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Endereço não encontrado!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PatchMapping("/{id}")
    ResponseEntity<MensagemSucessoResponse> updateAddressById(@PathVariable @NotNull Integer id, @RequestBody @Valid UpdateAddressRequest updateAddressRequest);

    @Operation(summary = "Remover um endereço", description = "Realiza a exclusão de um endereço do sistema com base no ID informado na URL.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Endereço removido com sucesso!"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos na requisição!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Endereço não encontrado!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))
           )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAddressById(@PathVariable @NotNull Integer id);

}