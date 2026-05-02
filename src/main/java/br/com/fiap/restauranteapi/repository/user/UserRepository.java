package br.com.fiap.restauranteapi.repository.user;

import br.com.fiap.restauranteapi.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);

    @Query("""
            SELECT u
            FROM User u
            WHERE LOWER(REPLACE(u.nome, ' ', '')) = LOWER(REPLACE(:nome, ' ', ''))
            """)
    Optional<User> findByNome(@Param("nome") String nome);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByLoginIgnoreCase(String login);

}