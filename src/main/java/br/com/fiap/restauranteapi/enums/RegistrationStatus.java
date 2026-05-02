package br.com.fiap.restauranteapi.enums;

import lombok.Getter;

@Getter
public enum RegistrationStatus {

    ACTIVE(1, "ATIVO"),
    DELETED(2, "EXCLUIDO");

    private final int id;
    private final String description;

    RegistrationStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }
}