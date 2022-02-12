package com.example.yonseitalk.web.account.dto;

import com.example.yonseitalk.web.account.domain.Account;
import lombok.Data;

@Data
public class AccountRegisterRequest {
    private String user_id;
    private String name;
    private String password;
    private String type;

    public Account toEntity(){
        return Account.builder()
                .accountId(user_id)
                .name(name)
                .password(password)
                .type(type)
                .build();
    }
}
