package br.com.fiap.restauranteapi.repository.tipousuario;

import br.com.fiap.restauranteapi.model.entity.tipousuario.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

}