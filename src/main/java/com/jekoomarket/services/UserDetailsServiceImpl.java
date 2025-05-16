package com.jekoomarket.services;

import com.jekoomarket.models.User;
import com.jekoomarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("Usuário não encontrado");
        return new UserDetailsImpl(user);
    }
}
