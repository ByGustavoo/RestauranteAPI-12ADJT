package br.com.fiap.restauranteapi.service.registrationstatus;

import br.com.fiap.restauranteapi.model.dto.registrationstatus.RegistrationStatusDTO;
import br.com.fiap.restauranteapi.repository.registrationstatus.RegistrationStatusRepository;
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