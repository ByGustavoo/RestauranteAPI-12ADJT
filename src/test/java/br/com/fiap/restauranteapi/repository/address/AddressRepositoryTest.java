package br.com.fiap.restauranteapi.repository.address;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class AddressRepositoryTest extends AbstractTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void findAllFetchUserTest() {
        var address = Assertions.assertDoesNotThrow(() -> addressRepository.findAllFetchUser(Pageable.unpaged()));
        Assertions.assertNotNull(address);
    }
}