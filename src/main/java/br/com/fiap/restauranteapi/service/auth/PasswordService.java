package br.com.fiap.restauranteapi.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService {

    private final PasswordEncoder passwordEncoder;

    public Boolean verifyPassword(String pRequestPassword, String pEncryptedPassword) {
        if (pRequestPassword == null || pRequestPassword.isBlank()) {
            throw new IllegalArgumentException("A senha informada não pode ser nula ou vazia!");
        }

        if (pEncryptedPassword == null || pEncryptedPassword.isBlank()) {
            throw new IllegalArgumentException("A senha do usuário não pode ser nula ou vazia!");
        }

        return passwordEncoder.matches(pRequestPassword, pEncryptedPassword);
    }

    public String encryptPassword(String pPassword) {
        if (pPassword == null || pPassword.isBlank()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia!");
        }

        return passwordEncoder.encode(pPassword);
    }
}