package ar.edu.unrn.shoppingservice.repository;

import ar.edu.unrn.shoppingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
