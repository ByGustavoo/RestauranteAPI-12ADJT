package br.com.fiap.restauranteapi.repository.usertype;

import br.com.fiap.restauranteapi.model.entity.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}