package com.emmanueldada.autobodyworkshop.controllers;


import com.emmanueldada.autobodyworkshop.dtos.UserDto;
import com.emmanueldada.autobodyworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto){
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash);

        LocalDate date = LocalDate.now();
        userDto.setCreatedat(date);

        System.out.println(userDto.getCreatedat());

        return userService.addUser(userDto);
    }

    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto){

        return userService.userLogin(userDto);
    }
}
