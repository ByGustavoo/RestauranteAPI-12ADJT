package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioMapper;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.model.request.usuario.CriarUsuarioRequest;
import br.com.fiap.restauranteapi.model.response.success.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.repository.situacaocadastro.SituacaoCadastroRepository;
import br.com.fiap.restauranteapi.repository.tipousuario.TipoUsuarioRepository;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
import br.com.fiap.restauranteapi.service.auth.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;

    private final PasswordService passwordService;

    private final UsuarioRepository usuarioRepository;

    private final TipoUsuarioRepository tipoUsuarioRepository;

    private final SituacaoCadastroRepository situacaoCadastroRepository;

    public Usuario getUsuarioByLogin(String pLogin) {
        return usuarioRepository.findByLogin(pLogin).orElseThrow(() -> new UsuarioNotFoundException("O Usuário com o login informado não foi encontrado!"));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioByNome(String pNome) {
        var usuario = usuarioRepository.findByNome(pNome).orElseThrow(() -> new UsuarioNotFoundException("O Usuário com o nome informado não foi encontrado!"));

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getLogin(),
                usuario.getTipoUsuario().getDescricao(),
                usuario.getSituacaoCadastro().getDescricao(),
                usuario.getDataAlteracao());
    }

    @Transactional
    public MensagemSucessoResponse salvarUsuario(CriarUsuarioRequest pCriarUsuarioRequest) {
        if (usuarioRepository.existsByEmailIgnoreCase(pCriarUsuarioRequest.email())) {
            throw new DataIntegrityViolationException("O E-mail informado já está cadastrado no sistema!");
        }

        if (usuarioRepository.existsByLoginIgnoreCase(pCriarUsuarioRequest.login())) {
            throw new DataIntegrityViolationException("O Login informado já está cadastrado no sistema!");
        }

        var usuario = usuarioMapper.fromCreateRequestToEntity(pCriarUsuarioRequest);
        usuario.setSenha(passwordService.encriptografarSenha(pCriarUsuarioRequest.senha()));
        usuario.setTipoUsuario(tipoUsuarioRepository.getReferenceById(pCriarUsuarioRequest.tipoUsuario()));
        usuario.setSituacaoCadastro(situacaoCadastroRepository.getReferenceById(ESituacaoCadastro.ATIVO.getCodigo()));

        usuarioRepository.save(usuario);
        return new MensagemSucessoResponse(HttpStatus.CREATED.value(), "Usuário cadastrado com sucesso!");
    }
}