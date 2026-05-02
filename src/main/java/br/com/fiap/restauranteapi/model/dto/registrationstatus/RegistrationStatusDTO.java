package br.com.fiap.restauranteapi.model.dto.registrationstatus;

import br.com.fiap.restauranteapi.model.entity.registrationstatus.RegistrationStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta com os dados de Situação de Cadastro")
public record RegistrationStatusDTO(

        @Schema(description = "Identificador único da situação de cadastro")
        Integer id,

        @Schema(description = "Descrição da situação de cadastro")
        String descricao

) {
    public RegistrationStatusDTO(RegistrationStatus pRegistrationStatus) {
        this(pRegistrationStatus.getId(), pRegistrationStatus.getDescricao());
    }
}