package ar.edu.unrn.shoppingservice.data.repository;

import ar.edu.unrn.shoppingservice.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Override
    Optional<ShoppingCart> findById(Long aLong);
}