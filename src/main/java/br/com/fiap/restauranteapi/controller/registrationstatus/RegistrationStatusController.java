package br.com.fiap.restauranteapi.controller.registrationstatus;

import br.com.fiap.restauranteapi.model.dto.registrationstatus.RegistrationStatusDTO;
import br.com.fiap.restauranteapi.service.registrationstatus.RegistrationStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/situacaocadastro")
public class RegistrationStatusController implements RegistrationStatusDocs {

    private final RegistrationStatusService registrationStatusService;

    @Override
    public ResponseEntity<List<RegistrationStatusDTO>> getAll() {
        return ResponseEntity.ok(registrationStatusService.findAll());
    }
}