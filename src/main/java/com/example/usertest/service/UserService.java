package com.example.usertest.service;

import com.example.usertest.dto.UserDto;
import com.example.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository db1Repository;
    private final UserRepository db2Repository;

    public UserService(@Qualifier("db1Repository") UserRepository db1Repository,
                       @Qualifier("db2Repository") UserRepository db2Repository) {
        this.db1Repository = db1Repository;
        this.db2Repository = db2Repository;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> result = new ArrayList<>();
        result.addAll(db1Repository.findAll());
        result.addAll(db2Repository.findAll());
        return result;
    }
}
