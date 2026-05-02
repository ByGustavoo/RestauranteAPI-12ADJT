package br.com.fiap.restauranteapi.model.mapper.user;

import br.com.fiap.restauranteapi.model.entity.user.User;
import br.com.fiap.restauranteapi.model.request.user.CreateUserRequest;
import br.com.fiap.restauranteapi.model.request.user.UpdateUserRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "situacaoCadastro.id", ignore = true)
    User fromCreateRequestToEntity(CreateUserRequest createUserRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "login", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "situacaoCadastro", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(UpdateUserRequest updateUserRequest, @MappingTarget User entity);

}