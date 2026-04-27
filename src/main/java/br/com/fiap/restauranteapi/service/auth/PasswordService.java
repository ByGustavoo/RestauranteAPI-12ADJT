package br.com.fiap.restauranteapi.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService {

    private final PasswordEncoder passwordEncoder;

    public Boolean verificarSenha(String pRequestSenha, String pSenhaCriptografada) {
        if (pRequestSenha == null || pRequestSenha.isBlank()) {
            throw new IllegalArgumentException("A senha informada não pode ser nula ou vazia!");
        }

        if (pSenhaCriptografada == null || pSenhaCriptografada.isBlank()) {
            throw new IllegalArgumentException("A senha do usuário não pode ser nula ou vazia!");
        }

        return passwordEncoder.matches(pRequestSenha, pSenhaCriptografada);
    }

    public String encriptografarSenha(String pSenha) {
        if (pSenha == null || pSenha.isBlank()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia!");
        }

        return passwordEncoder.encode(pSenha);
    }
}