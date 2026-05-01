package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.enums.SituacaoCadastro;
import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.model.request.usuario.AtualizarUsuarioRequest;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioMapper;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.model.request.usuario.BuscarUsuarioRequest;
import br.com.fiap.restauranteapi.model.request.usuario.CriarUsuarioRequest;
import br.com.fiap.restauranteapi.model.response.success.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.repository.situacaocadastro.SituacaoCadastroRepository;
import br.com.fiap.restauranteapi.repository.tipousuario.TipoUsuarioRepository;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
import br.com.fiap.restauranteapi.service.auth.PasswordService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

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
    public UsuarioDTO getUsuarioByNome(BuscarUsuarioRequest pBuscarUsuarioRequest) {
        var usuario = usuarioRepository.findByNome(pBuscarUsuarioRequest.nome()).orElseThrow(() -> new UsuarioNotFoundException("O Usuário com o nome informado não foi encontrado!"));

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
        usuario.setSituacaoCadastro(situacaoCadastroRepository.getReferenceById(SituacaoCadastro.ATIVO.getCodigo()));

        usuarioRepository.save(usuario);
        return new MensagemSucessoResponse(HttpStatus.CREATED.value(), "Usuário cadastrado com sucesso!");
    }

    @Transactional
    public MensagemSucessoResponse updateUser(Integer pId, AtualizarUsuarioRequest pAtualizarUsuarioRequest) {
        var usuario = usuarioRepository.findById(pId).orElseThrow(EntityNotFoundException::new);
        usuarioMapper.updateUsuarioFromDTO(pAtualizarUsuarioRequest, usuario);

        if (pAtualizarUsuarioRequest.situacaoCadastro() != null) {
            usuario.setSituacaoCadastro(situacaoCadastroRepository.getReferenceById(SituacaoCadastro.ATIVO.getCodigo()));
        }

        usuario.setDataAlteracao(LocalDate.now());
        return new MensagemSucessoResponse(HttpStatus.OK.value(), "Usuário atualizado com sucesso!");
    }
}