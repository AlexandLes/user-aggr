package com.example.usertest.repository.impl;

import com.example.usertest.dto.UserDto;
import com.example.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("db2Repository")
public class UserRepositoryDb2Impl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryDb2Impl(@Qualifier("db2JdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserDto> findAll(String idFilter, String usernameFilter) {
        String sql = "SELECT ldap_login AS id, ldap_login AS username, name, surname FROM user_table WHERE 1=1";
        List<Object> params = new ArrayList<>();

        if (idFilter != null && !idFilter.isEmpty()) {
            sql += " AND ldap_login = ?";
            params.add(idFilter);
        }

        if (usernameFilter != null && !usernameFilter.isEmpty()) {
            sql += " AND ldap_login = ?";
            params.add(usernameFilter);
        }

        return jdbcTemplate.query(sql, params.toArray(), (rs, rowNum) ->
                new UserDto(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("surname")
                )
        );
    }
}