package br.com.fiap.restauranteapi.enums;

import lombok.Getter;

@Getter
public enum UserType {

    OWNER(1, "DONO"),
    CUSTOMER(2, "CLIENTE");

    private final int id;
    private final String description;

    UserType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}