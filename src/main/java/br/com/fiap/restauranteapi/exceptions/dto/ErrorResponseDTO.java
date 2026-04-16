package br.com.fiap.restauranteapi.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ErrorResponseDTO(

        int status,

        String error,

        String message,

        String details,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp

) {
    public ErrorResponseDTO(int pStatus, String pError, String pMessage, String pDetails) {
        this(pStatus, pError, pMessage, pDetails, LocalDateTime.now());
    }
}