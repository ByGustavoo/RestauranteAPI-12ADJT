package br.com.fiap.restauranteapi.model.dto.usuario;

import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "situacaoCadastro.id", ignore = true)
    Usuario fromCreateDTOToEntity(CreateUsuarioDTO createUsuarioDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "situacaoCadastro", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUsuarioFromDto(AtualizarUsuarioRequest dto, @MappingTarget Usuario entity);
}