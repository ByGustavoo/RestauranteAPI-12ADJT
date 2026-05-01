package br.com.fiap.restauranteapi.service.situacaocadastro;

import br.com.fiap.restauranteapi.model.dto.situacaocadastro.RegistrationStatusDTO;
import br.com.fiap.restauranteapi.repository.situacaocadastro.RegistrationStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationStatusService {

    private final RegistrationStatusRepository registrationStatusRepository;

    @Transactional(readOnly = true)
    public List<RegistrationStatusDTO> findAll() {
        var registrationStatus = registrationStatusRepository.findAll();

        return registrationStatus.stream()
                .map(RegistrationStatusDTO::new)
                .toList();
    }
}