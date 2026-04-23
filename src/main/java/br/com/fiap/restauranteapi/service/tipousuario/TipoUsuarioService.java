package br.com.fiap.restauranteapi.service.tipousuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.repository.tipousuario.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    @Transactional(readOnly = true)
    public TipoUsuarioDTO getTipoUsuarioById(Integer pId) {
        var tipoUsuario = tipoUsuarioRepository.getReferenceById(pId);
        return new TipoUsuarioDTO(tipoUsuario.getId(), tipoUsuario.getDescricao());
    }
}