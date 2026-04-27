package br.com.fiap.restauranteapi.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.net.URI;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Estrutura genérica para respostas de erro da API")
public record ErrorResponseDTO(

        @Schema(description = "Código HTTP da resposta")
        int status,

        @Schema(description = "Título resumido do erro")
        String title,

        @Schema(description = "Detalhes adicionais do erro")
        String details,

        @Schema(description = "Endpoint onde ocorreu o erro")
        String instance,

        @Schema(description = "Data e hora em que o erro ocorreu")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp,

        @Schema(description = "Lista de erros de validação")
        Object errors

) {
    public ErrorResponseDTO(int pStatus, String pTitle, String pDetails, String pInstance) {
        this(pStatus, pTitle, pDetails, String.valueOf(URI.create(pInstance)), LocalDateTime.now(), null);
    }

    public ErrorResponseDTO(int pStatus, String pTitle, String pDetails, String pInstance, Object pErrors) {
        this(pStatus, pTitle, pDetails, pInstance, LocalDateTime.now(), pErrors);
    }
}