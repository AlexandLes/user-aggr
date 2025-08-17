package com.example.usertest.repository;

import com.example.usertest.dto.UserDto;

import java.util.List;

public interface UserRepository {
    List<UserDto> findAll(String idFilter, String usernameFilter);
}