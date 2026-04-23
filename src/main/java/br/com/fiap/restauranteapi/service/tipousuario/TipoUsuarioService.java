package br.com.fiap.restauranteapi.service.tipousuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.repository.tipousuario.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioDTO getTipoUsuarioById(Integer id) {
        var tipoUsuario = tipoUsuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de Usuário não encontrado com o ID: " + id));
        return new TipoUsuarioDTO(tipoUsuario.getId(), tipoUsuario.getDescricao());
    }
}