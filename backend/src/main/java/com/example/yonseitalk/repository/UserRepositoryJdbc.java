package com.example.yonseitalk.repository;

import com.example.yonseitalk.domain.User;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


public class UserRepositoryJdbc implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    public UserRepositoryJdbc(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public User save(User user) {
        jdbcTemplate.update("insert into YT_USER values ( ? , ? , ? , ? , ? , ? , ? , ? )",userPrepared(user));
        return user;
    }

    @Override
    public Optional<User> findById(String userId) {
        List<User> result = jdbcTemplate.query("select * from YT_USER where user_id = ?", userRowMapper(), userId);
        return result.stream().findAny();
    }

    @Override
    public List<User> searchUser(String name) {
        List<User> result = jdbcTemplate.query("select * from YT_USER where name ilike \'%"+name+"%\'", userRowMapper());
        return result;
    }

    @Override
    public void modifyStatusMessage(User user, String newStatusMessage) {
        jdbcTemplate.update("update YT_USER set status_message = ? where user_id = ?",newStatusMessage,user.getUserId());
    }

    @Override
    public void deleteUser(User user) {
        jdbcTemplate.update("delete YT_USER where user_id = ?",user.getUserId());
    }
    PreparedStatementSetter userPrepared(User user){
        return (ps ->{
            ps.setString(1,user.getUserId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getPassword());
            ps.setTimestamp(4,user.getUserTime());
            ps.setString(5,user.getStatusMessage());
            ps.setString(6,user.getType());
            ps.setBoolean(7,user.getConnectionStatus());
            ps.setString(8,user.getUserLocation());
        });
    }
    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getString("user_id"));
            user.setName(rs.getString("name"));
            user.setUserTime(rs.getTimestamp("user_time"));
            user.setPassword(rs.getString("password"));
            user.setUserLocation(rs.getString("user_location"));
            user.setStatusMessage(rs.getString("status_message"));
            user.setType(rs.getString("type"));
            user.setConnectionStatus(rs.getBoolean("connection_status"));
            return user;
        };
    }

}
