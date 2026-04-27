package br.com.fiap.restauranteapi.repository.usuario;

import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLogin(String login);

    boolean existsByLoginIgnoreCase(String login);

    @Query("""
            SELECT u
            FROM Usuario u
            WHERE LOWER(REPLACE(u.nome, ' ', '')) = LOWER(REPLACE(:nome, ' ', ''))
            """)
    Optional<Usuario> findByNome(@Param("nome") String nome);

    boolean existsByEmailIgnoreCase(String email);

}