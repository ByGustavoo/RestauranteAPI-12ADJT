package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.service.endereco.EnderecoService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Hidden
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(enderecoService.getEnderecoById(id));
    }
}