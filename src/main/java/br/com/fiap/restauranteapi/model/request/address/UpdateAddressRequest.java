package br.com.fiap.restauranteapi.model.request.address;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de request para atualizar os dados de Endereço do Usuário")
public record UpdateAddressRequest(

        @Pattern(regexp = ".*\\S.*", message = "O campo 'rua' não pode ser vazio!")
        @Schema(description = "Nome da rua", example = "Rua das Flores")
        String rua,

        @Pattern(regexp = ".*\\S.*", message = "O campo 'cidade' não pode ser vazio!")
        @Schema(description = "Cidade", example = "São Paulo")
        String cidade,

        @Schema(description = "Estado", example = "SP", minLength = 2, maxLength = 2)
        @Size(min = 2, max = 2, message = "O campo 'estado' deve conter exatamente 2 caracteres!")
        String estado,

        @Pattern(regexp = ".*\\S.*", message = "O campo 'complemento' não pode ser vazio!")
        @Schema(description = "Complemento do endereço", example = "Casa, apartamento, etc.")
        String complemento,

        @Pattern(regexp = ".*\\S.*", message = "O campo 'pontoReferencia' não pode ser vazio!")
        @Schema(description = "Ponto de referência", example = "Próximo ao supermercado")
        String pontoReferencia,

        @Schema(description = "CEP", example = "12345-678", minLength = 9, maxLength = 9)
        @Size(min = 9, max = 9, message = "O campo 'cep' deve conter exatamente 9 caracteres (formato XXXXX-XXX)!")
        String cep

) {}