package com.emmanueldada.autobodyworkshop.services;

import com.emmanueldada.autobodyworkshop.dtos.UserDto;
import com.emmanueldada.autobodyworkshop.entities.User;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface UserService {
    //The 'CREATE' function of the project
    @Transactional
    User addUser(UserDto userDto);

    //The 'READ' function of the project
    @Transactional
    Optional<UserDto> getUserById(Integer userId);

    //The 'UPDATE' function of the project
    @Transactional
    User updateUser(UserDto userDto);

    //The 'DELETE' function of the project
    @Transactional
    User deleteUser(Integer userId);
}
