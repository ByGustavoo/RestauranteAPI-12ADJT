package br.com.fiap.restauranteapi.model.dto.endereco;

public record EnderecoDTO(

        Integer id,

        String nomeUsuario,

        String rua,

        String cidade,

        String estado,

        String complemento,

        String pontoReferencia,

        String cep

) {}