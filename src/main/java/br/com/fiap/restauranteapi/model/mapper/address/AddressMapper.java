package br.com.fiap.restauranteapi.model.mapper.address;

import br.com.fiap.restauranteapi.model.entity.address.Address;
import br.com.fiap.restauranteapi.model.request.address.CreateAddressRequest;
import br.com.fiap.restauranteapi.model.request.address.UpdateAddressRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Address fromCreateRequestToEntity(CreateAddressRequest createAddressRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAddress(UpdateAddressRequest updateAddressRequest, @MappingTarget Address address);

}