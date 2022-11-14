package ar.edu.unrn.shoppingservice.security.service;

import ar.edu.unrn.shoppingservice.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unrn.shoppingservice.security.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
