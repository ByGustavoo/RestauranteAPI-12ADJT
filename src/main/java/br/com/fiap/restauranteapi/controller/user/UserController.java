package br.com.fiap.restauranteapi.controller.user;

import br.com.fiap.restauranteapi.model.dto.user.UserDTO;
import br.com.fiap.restauranteapi.model.request.user.CreateUserRequest;
import br.com.fiap.restauranteapi.model.request.user.SearchUserByNameRequest;
import br.com.fiap.restauranteapi.model.request.user.UpdateUserRequest;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.service.user.UserService;
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
    public ResponseEntity<UserDTO> getUserByName(@RequestBody @Valid SearchUserByNameRequest searchUserByNameRequest) {
        return ResponseEntity.ok(userService.findUserByName(searchUserByNameRequest));
    }

    @Override
    public ResponseEntity<SuccessMessageResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(userService.saveUser(createUserRequest));
    }

    @Override
    public ResponseEntity<SuccessMessageResponse> updateUserById(@PathVariable Integer id, @RequestBody @Valid UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(userService.updateUserById(id, updateUserRequest));
    }

    @Override
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}