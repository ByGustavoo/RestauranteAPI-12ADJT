package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.request.usuario.AtualizarUsuarioRequest;
import br.com.fiap.restauranteapi.model.request.usuario.BuscarUsuarioRequest;
import br.com.fiap.restauranteapi.model.request.usuario.CriarUsuarioRequest;
import br.com.fiap.restauranteapi.model.response.success.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.service.usuario.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuario")
public class UsuarioController implements UsuarioDocs {

    private final UsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioDTO> getUsuarioByNome(@RequestBody @Valid BuscarUsuarioRequest buscarUsuarioRequest) {
        return ResponseEntity.ok(usuarioService.getUsuarioByNome(buscarUsuarioRequest));
    }

    @Override
    public ResponseEntity<MensagemSucessoResponse> cadastrarUsuario(@RequestBody @Valid CriarUsuarioRequest criarUsuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(usuarioService.salvarUsuario(criarUsuarioRequest));
    }

    @Override
    public ResponseEntity<MensagemSucessoResponse> atualizarUsuario(@PathVariable Integer id, @RequestBody @Valid AtualizarUsuarioRequest atualizarUsuarioRequest) {
        return ResponseEntity.ok(usuarioService.updateUser(id, atualizarUsuarioRequest));
    }
}