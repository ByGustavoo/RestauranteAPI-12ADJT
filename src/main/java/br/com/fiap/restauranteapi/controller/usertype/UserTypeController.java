package br.com.fiap.restauranteapi.controller.usertype;

import br.com.fiap.restauranteapi.model.dto.usertype.UserTypeDTO;
import br.com.fiap.restauranteapi.service.usertype.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tipousuario")
public class UserTypeController implements UserTypeDocs {

    private final UserTypeService userTypeService;

    @Override
    public ResponseEntity<List<UserTypeDTO>> getAll() {
        return ResponseEntity.ok(userTypeService.findAll());
    }
}