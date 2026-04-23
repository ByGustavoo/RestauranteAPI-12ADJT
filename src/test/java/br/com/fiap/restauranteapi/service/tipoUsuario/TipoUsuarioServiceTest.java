package br.com.fiap.restauranteapi.service.tipoUsuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.service.tipousuario.TipoUsuarioService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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