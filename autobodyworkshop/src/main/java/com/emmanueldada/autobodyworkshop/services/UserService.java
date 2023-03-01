package com.emmanueldada.autobodyworkshop.services;


import com.emmanueldada.autobodyworkshop.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
