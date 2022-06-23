package ru.itis.examweb.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.examweb.models.User;

import java.util.Collection;

public class UserDetailImple implements UserDetails {

    public User user;

    public UserDetailImple(User user) {
        this.user = user;

        System.out.println(user != null ? (user.getName()  +  ":" + new BCryptPasswordEncoder().matches("admin", user.getPassword())): "user not found");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
