package ar.edu.unrn.shoppingservice.security.service;

import ar.edu.unrn.shoppingservice.security.entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unrn.shoppingservice.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username).get();
        return UserPrincipal.build(user);
    }
}
