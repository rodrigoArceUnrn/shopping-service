package ar.edu.unrn.shoppingservice.repository;

import ar.edu.unrn.shoppingservice.model.Client;
import ar.edu.unrn.shoppingservice.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
