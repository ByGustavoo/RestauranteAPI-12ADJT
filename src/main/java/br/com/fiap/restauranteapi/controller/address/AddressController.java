package br.com.fiap.restauranteapi.controller.address;

import br.com.fiap.restauranteapi.model.dto.address.AddressDTO;
import br.com.fiap.restauranteapi.model.request.address.CreateAddressRequest;
import br.com.fiap.restauranteapi.model.request.address.UpdateAddressRequest;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import br.com.fiap.restauranteapi.model.response.success.SuccessMessageResponse;
import br.com.fiap.restauranteapi.service.address.AddressService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
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
public class AddressController implements AddressDocs {

    private final AddressService addressService;

    @Override
    public ResponseEntity<PageResponse<AddressDTO>> getAll(@Parameter(hidden = true) @PageableDefault(size = 100, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(addressService.findAll(pageable));
    }

    @Override
    public ResponseEntity<SuccessMessageResponse> saveAddress(@RequestBody @Valid CreateAddressRequest createAddressRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(addressService.saveAddress(createAddressRequest));
    }

    @Override
    public ResponseEntity<SuccessMessageResponse> updateAddressById(@PathVariable Integer id, @RequestBody @Valid UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(addressService.updateAddressById(id, updateAddressRequest));
    }

    @Override
    public ResponseEntity<Void> deleteAddressById(@PathVariable Integer id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.noContent().build();
    }
}