package com.example.usertest.repository.impl;

import com.example.usertest.dto.UserDto;
import com.example.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("db1Repository")
public class UserRepositoryDb1Impl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryDb1Impl(@Qualifier("db1JdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserDto> findAll(String idFilter, String usernameFilter) {
        String sql = "SELECT user_id::text AS id, login, first_name, last_name FROM users WHERE 1=1";
        List<Object> params = new ArrayList<>();

        if (idFilter != null && !idFilter.isEmpty()) {
            sql += " AND user_id::text = ?";
            params.add(idFilter);
        }

        if (usernameFilter != null && !usernameFilter.isEmpty()) {
            sql += " AND login = ?";
            params.add(usernameFilter);
        }

        return jdbcTemplate.query(sql, params.toArray(), (rs, rowNum) ->
                new UserDto(
                        rs.getString("id"),
                        rs.getString("login"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                )
        );
    }
}
