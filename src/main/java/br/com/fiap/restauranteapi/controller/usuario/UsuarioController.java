package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.service.usuario.UsuarioService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @GetMapping(params = "nome")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorNomeQuery(@RequestParam String nome) {
        return ResponseEntity.ok(usuarioService.getUsuarioByNome(nome));
    }
}