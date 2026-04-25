package br.com.fiap.restauranteapi.model.dto.usuario;

import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataAlteracao", expression = "java(java.time.LocalDateTime.now())")
    Usuario fromCreateDTOToEntity(CreateUsuarioDTO createUsuarioDTO);

}