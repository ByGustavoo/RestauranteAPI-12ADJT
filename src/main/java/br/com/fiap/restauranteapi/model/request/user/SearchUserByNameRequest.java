package br.com.fiap.restauranteapi.model.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Modelo de request para buscar um Usuário pelo nome")
public record SearchUserByNameRequest(

        @NotBlank(message = "O campo 'nome' é obrigatório!")
        @Schema(description = "Nome do usuário que deseja buscar", example = "João Silva")
        String nome

) {}