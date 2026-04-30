package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.model.request.endereco.CriarEnderecoRequest;
import br.com.fiap.restauranteapi.model.request.endereco.UpdateAddressRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class EnderecoServiceTest extends AbstractTest {

    @Autowired
    private EnderecoService enderecoService;

    @Test
    void findAllTest() {
        var endereco = enderecoService.findAll(Pageable.unpaged());
        Assertions.assertNotNull(endereco);
    }

    @Test
    void saveAddressTest() {

        var address = new CriarEnderecoRequest(
                1,
                "123",
                "Bairro Teste",
                "SP",
                "Perto do supermercado",
                "",
                "12345-678"
        );

        Assertions.assertDoesNotThrow(() -> enderecoService.saveAddress(address));
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

        Assertions.assertDoesNotThrow(() -> enderecoService.updateAddressById(1, address));
    }

    @Test
    void deleteAddressByIdTest() {
        Assertions.assertDoesNotThrow(() -> enderecoService.deleteAddressById(1));
    }
}