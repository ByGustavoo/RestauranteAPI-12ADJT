package br.com.fiap.restauranteapi.model.request.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de request para atualizar os dados de Endereço do Usuário")
public record UpdateAddressRequest(

        @Schema(description = "Nome da rua", example = "Rua das Flores")
        String rua,

        @Schema(description = "Cidade", example = "São Paulo")
        String cidade,

        @Schema(description = "Estado", example = "SP")
        @Size(min = 2, max = 2, message = "O campo 'estado' deve conter exatamente 2 caracteres!")
        String estado,

        @Schema(description = "Complemento do endereço", example = "Casa, apartamento, etc.")
        String complemento,

        @Schema(description = "Ponto de referência", example = "Próximo ao supermercado")
        String pontoReferencia,

        @Schema(description = "CEP", example = "12345-678")
        @Size(min = 9, max = 9, message = "O campo 'cep' deve conter exatamente 9 caracteres (formato XXXXX-XXX)!")
        String cep

) {}