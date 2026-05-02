package br.com.fiap.restauranteapi.model.dto.address;

import br.com.fiap.restauranteapi.model.entity.address.Address;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta com os dados de Endereço do Usuário")
public record AddressDTO(

        @Schema(description = "Identificador único do endereço")
        Integer id,

        @Schema(description = "Identificador único do usuário proprietário do endereço")
        Integer usuarioId,

        @Schema(description = "Nome da rua")
        String rua,

        @Schema(description = "Cidade")
        String cidade,

        @Schema(description = "Estado")
        String estado,

        @Schema(description = "Complemento do endereço")
        String complemento,

        @Schema(description = "Ponto de referência")
        String pontoReferencia,

        @Schema(description = "CEP")
        String cep

) {
    public AddressDTO(Address pAddress) {
        this(pAddress.getId(), pAddress.getUsuario().getId(), pAddress.getRua(), pAddress.getCidade(), pAddress.getEstado(), pAddress.getComplemento(), pAddress.getPontoReferencia(), pAddress.getCep());
    }
}