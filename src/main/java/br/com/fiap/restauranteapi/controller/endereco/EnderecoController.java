package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.model.request.endereco.CriarEnderecoRequest;
import br.com.fiap.restauranteapi.model.request.endereco.UpdateAddressRequest;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import br.com.fiap.restauranteapi.model.response.success.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.service.endereco.EnderecoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/endereco")
public class EnderecoController implements EnderecoDocs {

    private final EnderecoService enderecoService;

    @Override
    public ResponseEntity<PageResponse<EnderecoDTO>> getAll(@Parameter(hidden = true) @PageableDefault(size = 100, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(enderecoService.findAll(pageable));
    }

    @Override
    public ResponseEntity<MensagemSucessoResponse> saveAddress(@RequestBody @Valid CriarEnderecoRequest criarEnderecoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(enderecoService.saveAddress(criarEnderecoRequest));
    }

    @Override
    public ResponseEntity<MensagemSucessoResponse> updateAddressById(@PathVariable @NotNull Integer id, @RequestBody @Valid UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(enderecoService.updateAddressById(id, updateAddressRequest));
    }

    @Override
    public ResponseEntity<Void> deleteAddressById(@PathVariable @NotNull Integer id) {
        enderecoService.deleteAddressById(id);
        return ResponseEntity.noContent().build();
    }
}