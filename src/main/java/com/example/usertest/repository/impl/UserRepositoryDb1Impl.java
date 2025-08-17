package com.example.usertest.repository.impl;

import com.example.usertest.dto.UserDto;
import com.example.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db1Repository")
public class UserRepositoryDb1Impl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryDb1Impl(@Qualifier("db1JdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserDto> findAll() {
        return jdbcTemplate.query(
                "SELECT user_id, login, first_name, last_name FROM users",
                (rs, rowNum) -> new UserDto(
                        String.valueOf(rs.getObject("user_id")),
                        rs.getString("login"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                )
        );
    }
}