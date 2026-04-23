package br.com.fiap.restauranteapi.repository.situacaocadastro;

import br.com.fiap.restauranteapi.model.entity.situacao.SituacaoCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoCadastroRepository extends JpaRepository<SituacaoCadastro, Integer> {

}