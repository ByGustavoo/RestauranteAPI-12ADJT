package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class UsuarioControllerTest extends AbstractControllerTest {

    private String usuario;

    private String buscarUsuario;

    @BeforeEach
    void setUp() throws IOException {
        if (usuario == null && buscarUsuario == null) {
            usuario = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/usuario.json")));
            buscarUsuario = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/buscarUsuario.json")));
        }
    }

    @Test
    void getUsuarioByNomeTest() throws Exception {
        testPostStatusOk("/v1/usuario/buscar", buscarUsuario);
    }

    @Test
    void cadastrarUsuarioTest() throws Exception {
        testPost("/v1/usuario", usuario);
    }
}