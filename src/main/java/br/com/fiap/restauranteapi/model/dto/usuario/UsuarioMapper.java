package br.com.fiap.restauranteapi.model.dto.usuario;

import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "situacaoCadastro.id", constant = "1")
    @Mapping(target = "dataAlteracao", expression = "java(java.time.LocalDate.now())")
    Usuario fromCreateDTOToEntity(CreateUsuarioDTO createUsuarioDTO);

}