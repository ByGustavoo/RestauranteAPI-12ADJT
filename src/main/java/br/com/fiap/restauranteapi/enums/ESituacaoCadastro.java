package br.com.fiap.restauranteapi.enums;

import lombok.Getter;

@Getter
public enum ESituacaoCadastro {

    ATIVO(1, "ATIVO"),
    EXCLUIDO(2, "EXCLUIDO");

    private final int codigo;
    private final String descricao;

    ESituacaoCadastro(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}