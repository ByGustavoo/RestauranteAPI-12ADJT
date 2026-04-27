package br.com.fiap.restauranteapi.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Resposta padrão indicando que a operação foi concluída com sucesso.")
public record MensagemSucessoResponse(

        @Schema(description = "Código HTTP da resposta")
        int status,

        @Schema(description = "Data e hora da resposta")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp,

        @Schema(description = "Mensagem de sucesso")
        String mensagem

) {
    public MensagemSucessoResponse(int pStatus, String pMessage) {
        this(pStatus, LocalDateTime.now(), pMessage);
    }
}