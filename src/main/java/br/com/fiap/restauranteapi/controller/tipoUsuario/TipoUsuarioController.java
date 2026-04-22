package br.com.fiap.restauranteapi.controller.tipoUsuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.service.TipoUsuario.TipoUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tipoUsuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> buscarTipoUsuarioPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(tipoUsuarioService.getTipoUsuarioById(id));
    }
}
