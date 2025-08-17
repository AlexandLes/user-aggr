package com.example.usertest.repository.impl;

import com.example.usertest.dto.UserDto;
import com.example.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db2Repository")
public class UserRepositoryDb2Impl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryDb2Impl(@Qualifier("db2JdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserDto> findAll() {
        return jdbcTemplate.query(
                "SELECT ldap_login, ldap_login AS username, name, surname FROM user_table",
                (rs, rowNum) -> new UserDto(
                        rs.getString("ldap_login"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("surname")
                )
        );
    }
}