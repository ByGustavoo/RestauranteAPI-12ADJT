package br.com.fiap.restauranteapi.repository.registrationstatus;

import br.com.fiap.restauranteapi.model.entity.registrationstatus.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationStatusRepository extends JpaRepository<RegistrationStatus, Integer> {

}