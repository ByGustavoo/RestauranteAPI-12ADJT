package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.request.usuario.CriarUsuarioRequest;
import br.com.fiap.restauranteapi.model.response.success.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.service.usuario.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuario")
public class UsuarioController implements UsuarioDocs {

    private final UsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioDTO> getUsuarioByNome(@RequestParam @NotBlank String nome) {
        return ResponseEntity.ok(usuarioService.getUsuarioByNome(nome));
    }

    @Override
    public ResponseEntity<MensagemSucessoResponse> cadastrarUsuario(@RequestBody @Valid CriarUsuarioRequest criarUsuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(usuarioService.salvarUsuario(criarUsuarioRequest));
    }
}