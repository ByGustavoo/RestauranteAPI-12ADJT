package br.com.fiap.restauranteapi.service.tipousuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TipoUsuarioServiceTest extends AbstractTest {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

     @Test
        void getTipoUsuarioById() {
            var tipoUsuario = tipoUsuarioService.getTipoUsuarioById(1);

            assertNotNull(tipoUsuario);
            assertEquals(1, tipoUsuario.id());
        }
}