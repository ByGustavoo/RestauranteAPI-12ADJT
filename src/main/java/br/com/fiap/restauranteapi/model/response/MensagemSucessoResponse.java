package br.com.fiap.restauranteapi.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Resposta padrão indicando que a operação foi concluída com sucesso.")
public record MensagemSucessoResponse(

        @Schema(description = "Código HTTP da resposta", example = "200")
        int status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        @Schema(description = "Data e hora da resposta", example = "15/04/2026 - 20:45:00")
        LocalDateTime timestamp,

        @Schema(description = "Mensagem de sucesso", example = "Senha alterada com sucesso!")
        String mensagem

) {
    public MensagemSucessoResponse(int pStatus, String pMessage) {
        this(pStatus, LocalDateTime.now(), pMessage);
    }
}