package br.com.fiap.restauranteapi.service.address;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.model.request.address.CreateAddressRequest;
import br.com.fiap.restauranteapi.model.request.address.UpdateAddressRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class AddressServiceTest extends AbstractTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAllTest() {
        var address = addressService.findAll(Pageable.unpaged());
        Assertions.assertNotNull(address);
    }

    @Test
    void saveAddressTest() {

        var address = new CreateAddressRequest(
                1,
                "123",
                "Bairro Teste",
                "SP",
                "Perto do supermercado",
                "",
                "12345-678"
        );

        Assertions.assertDoesNotThrow(() -> addressService.saveAddress(address));
    }

    @Test
    void updateAddressByIdTest() {

        var address = new UpdateAddressRequest(
                "123",
                "Bairro Teste",
                "SP",
                "Perto do supermercado",
                "",
                "12345-678"
        );

        Assertions.assertDoesNotThrow(() -> addressService.updateAddressById(1, address));
    }

    @Test
    void updateAddressByIdStateNullTest() {

        var address = new UpdateAddressRequest(
                "123",
                "Bairro Teste",
                null,
                "Perto do supermercado",
                "",
                "12345-678"
        );

        Assertions.assertDoesNotThrow(() -> addressService.updateAddressById(1, address));
    }

    @Test
    void deleteAddressByIdTest() {
        Assertions.assertDoesNotThrow(() -> addressService.deleteAddressById(1));
    }
}