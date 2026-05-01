package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.model.dto.usuario.UserDTO;
import br.com.fiap.restauranteapi.model.request.usuario.CreateUserRequest;
import br.com.fiap.restauranteapi.model.request.usuario.findUserByNameRequest;
import br.com.fiap.restauranteapi.model.request.usuario.UpdateUserRequest;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.service.usuario.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuario")
public class UserController implements UserDocs {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDTO> getUserByName(@RequestBody @Valid findUserByNameRequest findUserByNameRequest) {
        return ResponseEntity.ok(userService.findUserByName(findUserByNameRequest));
    }

    @Override
    public ResponseEntity<SuccessMessageResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(userService.saveUser(createUserRequest));
    }

    @Override
    public ResponseEntity<SuccessMessageResponse> updateUser(@PathVariable Integer id, @RequestBody @Valid UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(userService.updateUser(id, updateUserRequest));
    }
}