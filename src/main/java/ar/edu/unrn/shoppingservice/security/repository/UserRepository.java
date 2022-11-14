package ar.edu.unrn.shoppingservice.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unrn.shoppingservice.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
