package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.exceptions.LoginNotFoundException;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario getUsuarioByLogin(String login) {
        return usuarioRepository.findByLogin(login).orElseThrow(LoginNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioById(Integer id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().getDescricao(),
                usuario.getSituacaoCadastro().getDescricao(),
                usuario.getDataAlteracao());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioByName(String nome) {
        String nomeNormalizado = nome.trim();
        Usuario usuario = usuarioRepository.findByNameNormalizado(nomeNormalizado)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o nome: " + nomeNormalizado));
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().getDescricao(),
                usuario.getSituacaoCadastro().getDescricao(),
            usuario.getDataAlteracao()
        );
    }
}