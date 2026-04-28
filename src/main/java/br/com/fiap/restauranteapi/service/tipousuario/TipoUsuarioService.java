package br.com.fiap.restauranteapi.service.tipousuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.repository.tipousuario.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    @Transactional(readOnly = true)
    public List<TipoUsuarioDTO> findAll() {
        var tiposUsuario = tipoUsuarioRepository.findAll();

        return tiposUsuario.stream()
                .map(TipoUsuarioDTO::new)
                .toList();
    }
}