package br.com.fiap.restauranteapi.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record AlterarSenhaResponse(

        int status,

        String message,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp

) {
    public AlterarSenhaResponse(int pStatus, String pMessage) {
        this(pStatus, pMessage, LocalDateTime.now());
    }
}