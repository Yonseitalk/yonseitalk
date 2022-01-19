package com.example.yonseitalk.Authentification;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class AccountSecurityAdapter extends User {
    private com.example.yonseitalk.domain.User user;

    public AccountSecurityAdapter(com.example.yonseitalk.domain.User user){
        super(user.getUser_id(),user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.user=user;
    }
}
