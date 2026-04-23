package br.com.fiap.restauranteapi.repository.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}