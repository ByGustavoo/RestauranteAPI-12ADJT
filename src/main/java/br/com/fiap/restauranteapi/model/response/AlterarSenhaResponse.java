package br.com.fiap.restauranteapi.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Resposta de sucesso para alteração de senha")
public record AlterarSenhaResponse(

        @Schema(description = "Código HTTP da resposta", example = "200")
        int status,

        @Schema(description = "Mensagem de sucesso", example = "Senha alterada com sucesso!")
        String mensagem,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        @Schema(description = "Data e hora da resposta", example = "15/04/2026 - 20:45:00")
        LocalDateTime timestamp

) {
    public AlterarSenhaResponse(int pStatus, String pMessage) {
        this(pStatus, pMessage, LocalDateTime.now());
    }
}