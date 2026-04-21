package br.com.fiap.restauranteapi.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Estrutura padrão para respostas de erro da API")
public record ErrorResponseDTO(

        @Schema(description = "Código HTTP da resposta")
        int status,

        @Schema(description = "Tipo do erro HTTP")
        String error,

        @Schema(description = "Mensagem principal do erro")
        String message,

        @Schema(description = "Detalhes adicionais do erro")
        String details,

        @Schema(description = "Data e hora em que o erro ocorreu")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp

) {
    public ErrorResponseDTO(int pStatus, String pError, String pMessage, String pDetails) {
        this(pStatus, pError, pMessage, pDetails, LocalDateTime.now());
    }
}