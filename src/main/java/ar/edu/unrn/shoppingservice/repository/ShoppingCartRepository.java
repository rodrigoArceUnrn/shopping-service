package ar.edu.unrn.shoppingservice.repository;

import ar.edu.unrn.shoppingservice.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}