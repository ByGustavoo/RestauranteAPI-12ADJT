package br.com.fiap.restauranteapi.model.dto.usertype;

import br.com.fiap.restauranteapi.model.entity.usertype.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta com os dados do Tipo de Usuário")
public record UserTypeDTO(

        @Schema(description = "Identificador único do tipo de usuário")
        Integer id,

        @Schema(description = "Descrição do tipo de usuário")
        String descricao

) {
    public UserTypeDTO(UserType pUserType) {
        this(pUserType.getId(), pUserType.getDescricao());
    }
}