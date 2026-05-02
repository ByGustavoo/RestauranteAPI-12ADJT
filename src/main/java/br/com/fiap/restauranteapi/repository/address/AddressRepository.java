package br.com.fiap.restauranteapi.repository.address;

import br.com.fiap.restauranteapi.model.entity.address.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("""
                SELECT e
                FROM Address e
                JOIN FETCH e.usuario
            """)
    Page<Address> findAllFetchUser(Pageable pageable);

}