package com.example.yonseitalk;


import com.example.yonseitalk.repository.UserRepository;
import com.example.yonseitalk.repository.UserRepositoryJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public UserRepository memberRepository() {
        return new UserRepositoryJdbc(dataSource);
    }

}
