package br.com.fiap.restauranteapi.model.request.address;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Modelo de request para criação de um Endereço")
public record CreateAddressRequest(

        @NotNull(message = "O campo 'usuarioId' é obrigatório!")
        @Min(value = 1, message = "O campo 'usuarioId' deve ser um número inteiro positivo!")
        @Schema(description = "Identificador único do usuário proprietário do endereço", minLength = 1, example = "1")
        Integer usuarioId,

        @NotBlank(message = "O campo 'rua' é obrigatório!")
        @Schema(description = "Nome da rua", example = "Rua das Flores")
        String rua,

        @NotBlank(message = "O campo 'cidade' é obrigatório!")
        @Schema(description = "Cidade", example = "São Paulo")
        String cidade,

        @NotBlank(message = "O campo 'estado' é obrigatório!")
        @Schema(description = "Estado", example = "SP", minLength = 2, maxLength = 2)
        @Size(min = 2, max = 2, message = "O campo 'estado' deve conter exatamente 2 caracteres!")
        String estado,

        @Schema(description = "Complemento do endereço", example = "Apartamento 101")
        @Pattern(regexp = ".*\\S.*", message = "O campo 'complemento' não pode ser vazio!")
        String complemento,

        @Schema(description = "Ponto de referência", example = "Próximo ao supermercado")
        @Pattern(regexp = ".*\\S.*", message = "O campo 'pontoReferencia' não pode ser vazio!")
        String pontoReferencia,

        @NotBlank(message = "O campo 'cep' é obrigatório!")
        @Schema(description = "CEP", example = "12345-678", minLength = 9, maxLength = 9)
        @Size(min = 9, max = 9, message = "O campo 'cep' deve conter exatamente 9 caracteres (formato XXXXX-XXX)!")
        String cep

) {}