package br.com.fiap.restauranteapi.controller.situacaoCadastro;

import br.com.fiap.restauranteapi.model.dto.situacao.SituacaoCadastroDTO;
import br.com.fiap.restauranteapi.service.situacaoCadastro.SituacaoCadastroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/situacaoCadastro")
public class SituacaoCadastroController {

    private final SituacaoCadastroService situacaoCadastroService;

    public SituacaoCadastroController(SituacaoCadastroService situacaoCadastroService) {
        this.situacaoCadastroService = situacaoCadastroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoCadastroDTO> buscarSituacaoCadastroPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(situacaoCadastroService.getSituacaoCadastroById(id));
    }
}
