package br.com.fiap.restauranteapi.enums;

import lombok.Getter;

@Getter
public enum ETipoUsuario {

    DONO(1, "DONO"),
    CLIENTE(2, "CLIENTE");

    private final int codigo;
    private final String descricao;

    ETipoUsuario(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}