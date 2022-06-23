package ru.itis.examweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.examweb.models.User;
import ru.itis.examweb.repositories.UserRepository;
import ru.itis.examweb.services.UserDetailService;

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
        } throw new UsernameNotFoundException("Organization not found!");
    }
}
