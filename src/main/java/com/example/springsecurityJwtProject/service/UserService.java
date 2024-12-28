package com.example.springsecurityJwtProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurityJwtProject.Model.User;
import com.example.springsecurityJwtProject.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(username).orElseThrow();
        if (u != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(u.getEmail())
                    .password(u.getPassword()).roles(u.getRole().toString()).build();
        }
        // return userRepository.findByEmail(username).orElseThrow(()-> new
        // RuntimeException("error"+username));
        throw new UsernameNotFoundException("User Not found Exception");
    }

    public User saveUser(User u) {
        return userRepository.save(u);
    }
}
