package br.com.fiap.restauranteapi.service.user;

import br.com.fiap.restauranteapi.enums.RegistrationStatus;
import br.com.fiap.restauranteapi.exceptions.UserNotFoundException;
import br.com.fiap.restauranteapi.model.dto.user.UserDTO;
import br.com.fiap.restauranteapi.model.entity.user.User;
import br.com.fiap.restauranteapi.model.mapper.user.UserMapper;
import br.com.fiap.restauranteapi.model.request.user.CreateUserRequest;
import br.com.fiap.restauranteapi.model.request.user.SearchUserByNameRequest;
import br.com.fiap.restauranteapi.model.request.user.UpdateUserRequest;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.repository.registrationstatus.RegistrationStatusRepository;
import br.com.fiap.restauranteapi.repository.user.UserRepository;
import br.com.fiap.restauranteapi.repository.usertype.UserTypeRepository;
import br.com.fiap.restauranteapi.service.auth.PasswordService;
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

    public User findUserByLogin(String pLogin) {
        return userRepository.findByLogin(pLogin).orElseThrow(() -> new UserNotFoundException("O Usuário com o login informado não foi encontrado!"));
    }

    @Transactional(readOnly = true)
    public UserDTO findUserByName(SearchUserByNameRequest pSearchUserByNameRequest) {
        var user = userRepository.findByNome(pSearchUserByNameRequest.nome()).orElseThrow(() -> new UserNotFoundException("O Usuário com o nome informado não foi encontrado!"));

        return new UserDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getLogin(),
                user.getTipoUsuario().getDescricao(),
                user.getSituacaoCadastro().getDescricao(),
                user.getDataAlteracao());
    }

    @Transactional
    public SuccessMessageResponse saveUser(CreateUserRequest pCreateUserRequest) {
        validateEmailAlreadyExists(pCreateUserRequest.email(), null);

        if (userRepository.existsByLoginIgnoreCase(pCreateUserRequest.login())) {
            throw new DataIntegrityViolationException("O Login informado já está cadastrado no sistema!");
        }

        var user = userMapper.fromCreateRequestToEntity(pCreateUserRequest);
        user.setSenha(passwordService.encryptPassword(pCreateUserRequest.senha()));
        user.setTipoUsuario(userTypeRepository.getReferenceById(pCreateUserRequest.tipoUsuario()));
        user.setSituacaoCadastro(registrationStatusRepository.getReferenceById(RegistrationStatus.ACTIVE.getId()));

        userRepository.save(user);
        return new SuccessMessageResponse(HttpStatus.CREATED.value(), "Usuário cadastrado com sucesso!");
    }

    @Transactional
    public SuccessMessageResponse updateUserById(Integer pId, UpdateUserRequest pUpdateUserRequest) {
        var user = userRepository.findById(pId).orElseThrow(() -> new UserNotFoundException("O Usuário com o ID informado não foi encontrado!"));

        validateEmailAlreadyExists(pUpdateUserRequest.email(), pId);
        userMapper.updateUser(pUpdateUserRequest, user);

        if (pUpdateUserRequest.situacaoCadastro() != null) {
            user.setSituacaoCadastro(registrationStatusRepository.getReferenceById(RegistrationStatus.ACTIVE.getId()));
        }

        user.setDataAlteracao(LocalDate.now());
        return new SuccessMessageResponse(HttpStatus.OK.value(), "Usuário atualizado com sucesso!");
    }

    @Transactional
    public void deleteUserById(Integer pId) {
        var user = userRepository.findById(pId).orElseThrow(() -> new UserNotFoundException("O Usuário com o ID informado não foi encontrado!"));
        user.setSituacaoCadastro(registrationStatusRepository.getReferenceById(RegistrationStatus.DELETED.getId()));
    }

    private void validateEmailAlreadyExists(String pEmail, Integer pUserId) {
        if (pEmail == null || pEmail.isBlank()) {
            return;
        }

        boolean exists = pUserId == null ? userRepository.existsByEmailIgnoreCase(pEmail) : userRepository.existsByEmailIgnoreCaseAndIdNot(pEmail, pUserId);

        if (exists) {
            throw new DataIntegrityViolationException("O E-mail informado já está cadastrado no sistema!");
        }
    }
}