package br.com.fiap.restauranteapi.model.request;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaRequest(

        @NotBlank
        String login,

        @NotBlank
        String senhaAntiga,

        @NotBlank
        String senhaNova

) {}