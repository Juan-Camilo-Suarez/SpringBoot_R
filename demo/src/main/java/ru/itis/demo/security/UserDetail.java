package ru.itis.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UserRepository;
import ru.itis.demo.services.UserDetailService;


@Service(value = "myUserDetailService")
public class UserDetail implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailService userDetailsService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);

        if (user != null) {
            userDetailsService.setUser(user);
            //List<UserRole> roles = roleRepository.findByUser(user.getId());
            //user.setRoles(roles);
            return new UserDetailImple(user);
        } throw new UsernameNotFoundException("User not found!");
    }
}
