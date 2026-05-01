package br.com.fiap.restauranteapi.model.mapper.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Address;
import br.com.fiap.restauranteapi.model.request.endereco.CreateAddressRequest;
import br.com.fiap.restauranteapi.model.request.endereco.UpdateAddressRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "id_usuario", ignore = true)
    Address fromCreateRequestToEntity(CreateAddressRequest createAddressRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "id_usuario", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAddress(UpdateAddressRequest updateAddressRequest, @MappingTarget Address address);

}