package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.model.dto.usuario.CreateUsuarioDTO;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.service.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuario")
public class UsuarioController implements UsuarioDocs {

    private final UsuarioService usuarioService;

    @Hidden
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @Override
    public ResponseEntity<UsuarioDTO> getUsuarioByNome(@RequestParam @NotBlank String nome) {
        return ResponseEntity.ok(usuarioService.getUsuarioByNome(nome));
    }

    @Override
    public ResponseEntity<MensagemSucessoResponse> cadastrarUsuario(@RequestBody @Valid CreateUsuarioDTO createUsuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(usuarioService.salvarUsuario(createUsuarioDTO));
    }
}