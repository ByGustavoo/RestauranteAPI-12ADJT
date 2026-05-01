package br.com.fiap.restauranteapi.model.dto.usuario;

import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.model.request.usuario.AtualizarUsuarioRequest;
import br.com.fiap.restauranteapi.model.request.usuario.CriarUsuarioRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "situacaoCadastro.id", ignore = true)
    Usuario fromCreateRequestToEntity(CriarUsuarioRequest criarUsuarioRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "login", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "situacaoCadastro", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUsuarioFromDTO(AtualizarUsuarioRequest dto, @MappingTarget Usuario entity);

}