package br.com.fiap.restauranteapi.enums;

public enum Estado {

    AC, AL, AP, AM, BA, CE, DF, ES, GO,
    MA, MT, MS, MG, PA, PB, PR, PE, PI,
    RJ, RN, RS, RO, RR, SC, SP, SE, TO;

    public static void verificarEstado(String pEstado) {
        if (pEstado == null || pEstado.isBlank()) {
            throw new IllegalArgumentException("O campo 'estado' não pode estar vazio.");
        }

        try {
            Estado.valueOf(pEstado.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("O campo 'estado' deve conter um estado válido do Brasil!");
        }
    }
}