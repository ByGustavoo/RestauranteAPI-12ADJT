package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.enums.RegistrationStatus;
import br.com.fiap.restauranteapi.exceptions.UserNotFoundException;
import br.com.fiap.restauranteapi.model.dto.usuario.UserDTO;
import br.com.fiap.restauranteapi.model.entity.usuario.User;
import br.com.fiap.restauranteapi.model.mapper.usuario.UserMapper;
import br.com.fiap.restauranteapi.model.request.usuario.CreateUserRequest;
import br.com.fiap.restauranteapi.model.request.usuario.SearchUserByNameRequest;
import br.com.fiap.restauranteapi.model.request.usuario.UpdateUserRequest;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.repository.situacaocadastro.RegistrationStatusRepository;
import br.com.fiap.restauranteapi.repository.tipousuario.UserTypeRepository;
import br.com.fiap.restauranteapi.repository.usuario.UserRepository;
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
public class UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final PasswordService passwordService;

    private final UserTypeRepository userTypeRepository;

    private final RegistrationStatusRepository registrationStatusRepository;

    public User getUserByLogin(String pLogin) {
        return userRepository.findByLogin(pLogin).orElseThrow(() -> new UserNotFoundException("O Usuário com o login informado não foi encontrado!"));
    }

    @Transactional(readOnly = true)
    public UserDTO getUserByName(SearchUserByNameRequest pSearchUserByNameRequest) {
        var user = userRepository.findByNome(pSearchUserByNameRequest.nome()).orElseThrow(() -> new UserNotFoundException("O Usuário com o nome informado não foi encontrado!"));

        return new UserDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getLogin(),
                user.getId_tipousuario().getDescricao(),
                user.getId_situacaocadastro().getDescricao(),
                user.getDataAlteracao());
    }

    @Transactional
    public SuccessMessageResponse saveUser(CreateUserRequest pCreateUserRequest) {
        if (userRepository.existsByEmailIgnoreCase(pCreateUserRequest.email())) {
            throw new DataIntegrityViolationException("O E-mail informado já está cadastrado no sistema!");
        }

        if (userRepository.existsByLoginIgnoreCase(pCreateUserRequest.login())) {
            throw new DataIntegrityViolationException("O Login informado já está cadastrado no sistema!");
        }

        var user = userMapper.fromCreateRequestToEntity(pCreateUserRequest);
        user.setSenha(passwordService.encryptPassword(pCreateUserRequest.senha()));
        user.setId_tipousuario(userTypeRepository.getReferenceById(pCreateUserRequest.tipoUsuario()));
        user.setId_situacaocadastro(registrationStatusRepository.getReferenceById(RegistrationStatus.ACTIVE.getId()));

        userRepository.save(user);
        return new SuccessMessageResponse(HttpStatus.CREATED.value(), "Usuário cadastrado com sucesso!");
    }

    @Transactional
    public SuccessMessageResponse updateUser(Integer pId, UpdateUserRequest pUpdateUserRequest) {
        var user = userRepository.findById(pId).orElseThrow(EntityNotFoundException::new);
        userMapper.updateUser(pUpdateUserRequest, user);

        if (pUpdateUserRequest.situacaoCadastro() != null) {
            user.setId_situacaocadastro(registrationStatusRepository.getReferenceById(RegistrationStatus.ACTIVE.getId()));
        }

        user.setDataAlteracao(LocalDate.now());
        return new SuccessMessageResponse(HttpStatus.OK.value(), "Usuário atualizado com sucesso!");
    }
}