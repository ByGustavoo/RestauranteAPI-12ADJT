package br.com.fiap.restauranteapi.service.TipoUsuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.model.entity.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.repository.tipoUsuario.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public TipoUsuarioDTO getTipoUsuarioById(Integer id) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de Usuário não encontrado com o ID: " + id));
        return new TipoUsuarioDTO(tipoUsuario.getId(), tipoUsuario.getDescricao());
    }
}
