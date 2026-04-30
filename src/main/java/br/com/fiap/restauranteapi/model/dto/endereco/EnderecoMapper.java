package br.com.fiap.restauranteapi.model.dto.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import br.com.fiap.restauranteapi.model.request.endereco.CriarEnderecoRequest;
import br.com.fiap.restauranteapi.model.request.endereco.UpdateAddressRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Endereco fromCreateRequestToEntity(CriarEnderecoRequest criarEnderecoRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEnderecoFromDTO(UpdateAddressRequest updateAddressRequest, @MappingTarget Endereco endereco);

}