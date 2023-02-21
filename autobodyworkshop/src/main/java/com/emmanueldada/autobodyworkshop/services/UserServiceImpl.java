package com.emmanueldada.autobodyworkshop.services;

import com.emmanueldada.autobodyworkshop.dtos.UserDto;
import com.emmanueldada.autobodyworkshop.entities.User;
import com.emmanueldada.autobodyworkshop.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    //The 'CREATE' function of the project
    @Override
    @Transactional
    public User addUser(UserDto userDto){
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        return user;
    };

    //The 'READ' function of the project
    @Override
    @Transactional
    public Optional<UserDto> getUserById(Integer userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            return Optional.of(new UserDto(userOptional.get()));
        }
        return Optional.empty();
    }

    //The 'UPDATE' function of the project
    @Override
    @Transactional
    public User updateUser(UserDto userDto){
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setId(userDto.getId());
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
//            user.setAccountCreatedAt(userDto.getAccountCreatedAt()); <<<------Don't want the time stamp to be changed when a new user account is created, ADD back in if neccessary or if application runs into ERROR --- ASK Robert
            user.setPhoneNumber(userDto.getPhoneNumber());

            return user;
        }
        return new User();

    }

    //The 'DELETE' function of the project
    @Override
    @Transactional
    public User deleteUser(Integer userId){
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isPresent()){
            userRepository.delete(userOptional.get());
            return userOptional.get();
        }
        return new User();

    }


}
