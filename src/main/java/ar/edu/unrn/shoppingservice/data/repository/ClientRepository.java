package ar.edu.unrn.shoppingservice.data.repository;

import ar.edu.unrn.shoppingservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}