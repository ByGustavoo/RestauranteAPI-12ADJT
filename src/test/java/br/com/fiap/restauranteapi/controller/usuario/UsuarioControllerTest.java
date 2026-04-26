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

    @BeforeEach
    void setUp() throws IOException {
        if (usuario == null) {
            usuario = new String(Files.readAllBytes(Paths.get("src/test/resources/usuario/usuario.json")));
        }
    }

    @Test
    void getUsuarioByIdTest() throws Exception {
        testGet("/v1/usuario/1");
    }

    @Test
    void getUsuarioByNomeTest() throws Exception {
        testGet("/v1/usuario?nome=João Silva");
    }

    @Test
    void cadastrarUsuarioTest() throws Exception {
        testPost("/v1/usuario", usuario);
    }
}