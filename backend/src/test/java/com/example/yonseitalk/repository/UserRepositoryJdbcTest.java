package com.example.yonseitalk.repository;

import com.example.yonseitalk.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryJdbcTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void insertTest(){
        User user = new User();
        user.setUserId("testid2");
        user.setName("testname");
        user.setUserTime(new Timestamp(System.currentTimeMillis()));
        user.setPassword("1234");
        user.setUserLocation("gong");
        user.setStatusMessage("hello");
        user.setType("student");
        user.setConnectionStatus(true);
        userRepository.save(user);
    }
    @Test
    void findidTest(){
        User user = new User();
        user.setUserId("testid2");
        user.setName("testname");
        user.setUserTime(new Timestamp(System.currentTimeMillis()));
        user.setPassword("1234");
        user.setUserLocation("gong");
        user.setStatusMessage("hello");
        user.setType("student");
        user.setConnectionStatus(true);
        userRepository.save(user);


        User result = userRepository.findById(user.getUserId()).get();

        assertThat(result.getUserId()).isEqualTo(user.getUserId());

    }

    @Test
    void 검색쿼리(){
        User user = new User();
        user.setUserId("testid2");
        user.setName("testname3");
        user.setUserTime(new Timestamp(System.currentTimeMillis()));
        user.setPassword("1234");
        user.setUserLocation("gong");
        user.setStatusMessage("hello");
        user.setType("student");
        user.setConnectionStatus(true);
        userRepository.save(user);

        User result = userRepository.searchUser(user.getName()).stream().findAny().get();
        assertThat(result.getUserId()).isEqualTo(user.getUserId());

    }

    @Test
    void 수정쿼리(){
        User user = new User();
        user.setUserId("testid2");
        user.setName("testname3");
        user.setUserTime(new Timestamp(System.currentTimeMillis()));
        user.setPassword("1234");
        user.setUserLocation("gong");
        user.setStatusMessage("hello");
        user.setType("student");
        user.setConnectionStatus(true);
        userRepository.save(user);

        String newStatusMessage="new";
        userRepository.modifyStatusMessage(user,newStatusMessage);
        User result = userRepository.findById(user.getUserId()).get();
        assertThat(result.getStatusMessage()).isEqualTo(newStatusMessage);
    }

    @Test
    void 삭제쿼리(){
        User user = new User();
        user.setUserId("testid2");
        user.setName("testname3");
        user.setUserTime(new Timestamp(System.currentTimeMillis()));
        user.setPassword("1234");
        user.setUserLocation("gong");
        user.setStatusMessage("hello");
        user.setType("student");
        user.setConnectionStatus(true);
        userRepository.save(user);

        userRepository.deleteUser(user);
        Optional<User> result = userRepository.findById(user.getUserId());
        assertTrue(result.isEmpty());
    }


}