package com.example.yonseitalk.service;

import com.example.yonseitalk.Authentification.AccountSecurityAdapter;
import com.example.yonseitalk.domain.User;
import com.example.yonseitalk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

//    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=new User(); //userRepository.getById(s);

        user.setUser_id(s);
        user.setPassword("1234");
        return new AccountSecurityAdapter(user);
    }
}
