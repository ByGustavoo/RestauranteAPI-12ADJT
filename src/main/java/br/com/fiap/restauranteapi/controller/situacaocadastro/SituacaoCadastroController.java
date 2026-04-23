package br.com.fiap.restauranteapi.controller.situacaocadastro;

import br.com.fiap.restauranteapi.model.dto.situacao.SituacaoCadastroDTO;
import br.com.fiap.restauranteapi.service.situacaocadastro.SituacaoCadastroService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/situacaocadastro")
public class SituacaoCadastroController {

    private final SituacaoCadastroService situacaoCadastroService;

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoCadastroDTO> getSituacaoCadastroById(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(situacaoCadastroService.getSituacaoCadastroById(id));
    }
}