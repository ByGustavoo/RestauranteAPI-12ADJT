package br.com.fiap.restauranteapi.controller.tipousuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.service.tipousuario.TipoUsuarioService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tipousuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> getTipoUsuarioById(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(tipoUsuarioService.getTipoUsuarioById(id));
    }
}