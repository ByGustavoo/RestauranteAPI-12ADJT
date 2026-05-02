package br.com.fiap.restauranteapi.controller.user;

import br.com.fiap.restauranteapi.exceptions.dto.ErrorResponseDTO;
import br.com.fiap.restauranteapi.model.dto.user.UserDTO;
import br.com.fiap.restauranteapi.model.request.user.CreateUserRequest;
import br.com.fiap.restauranteapi.model.request.user.findUserByNameRequest;
import br.com.fiap.restauranteapi.model.request.user.UpdateUserRequest;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuário", description = "Endpoints relacionados ao gerenciamento de Usuários")
public interface UserDocs {

    @Operation(summary = "Buscar usuário por nome", description = "Retorna os dados de um usuário a partir do nome informado no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário encontrado com sucesso!",
                    content = @Content(schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos na requisição!",
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
    @PostMapping("/buscar")
    ResponseEntity<UserDTO> getUserByName(@RequestBody @Valid findUserByNameRequest findUserByNameRequest);

    @Operation(summary = "Cadastrar um usuário", description = "Realiza o cadastro de um novo usuário no sistema com base nos dados informados no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuário cadastrado com sucesso!",
                    content = @Content(schema = @Schema(implementation = SuccessMessageResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos na requisição!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "409",
                    description = "E-mail ou login já cadastrado no sistema!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping
    ResponseEntity<SuccessMessageResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest);


    @Operation(summary = "Atualizar usuário por ID", description = "Atualiza os dados do usuário com base no ID informado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário atualizado com sucesso!",
                    content = @Content(schema = @Schema(implementation = SuccessMessageResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos na requisição!",
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
    @PatchMapping("/{id}")
    ResponseEntity<SuccessMessageResponse> updateUserById(@PathVariable Integer id, @RequestBody @Valid UpdateUserRequest updateUserRequest);

    @Operation(summary = "Deletar um usuário", description = "Deleta um usuário do sistema com base no ID informado na URL.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Usuário removido com sucesso!"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos na requisição!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor!",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))
            )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUserById(@PathVariable Integer id);
}