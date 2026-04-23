package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.model.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario getUsuarioByLogin(String pLogin) {
        return usuarioRepository.findByLogin(pLogin).orElseThrow(() -> new UsuarioNotFoundException("O Usuário com o login informado não foi encontrado!"));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioById(Integer pId) {
        var usuario = usuarioRepository.getReferenceById(pId);

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().getDescricao(),
                usuario.getSituacaoCadastro().getDescricao(),
                usuario.getDataAlteracao());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioByNome(String pNome) {
        var usuario = usuarioRepository.findByNome(pNome).orElseThrow(() -> new UsuarioNotFoundException("O Usuário com o nome informado não foi encontrado!"));

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().getDescricao(),
                usuario.getSituacaoCadastro().getDescricao(),
                usuario.getDataAlteracao());
    }

    @Transactional
    public MensagemSucessoResponse createUser(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);

        return new MensagemSucessoResponse(HttpStatus.CREATED.value(), "Usuário cadastrado com sucesso!");
    }
}