package com.security.dbapi.service;

import com.security.dbapi.model.CustomUserDetails;
import com.security.dbapi.model.Users;
import com.security.dbapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername (String s) throws UsernameNotFoundException {
        Optional<Users> users = userRepository.findByName(s);

        users.orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        return users.map(CustomUserDetails::new).get();

    }
}
