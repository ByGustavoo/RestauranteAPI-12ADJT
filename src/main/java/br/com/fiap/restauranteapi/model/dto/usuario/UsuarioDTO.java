package br.com.fiap.restauranteapi.model.dto.usuario;

import java.time.LocalDate;

public record UsuarioDTO(

        Integer id,

        String nome,

        String email,

        String tipoUsuario,

        String situacaoCadastro,

        LocalDate dataAlteracao

) {}