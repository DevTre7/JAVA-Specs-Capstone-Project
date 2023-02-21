package com.emmanueldada.autobodyworkshop.dtos;

import com.emmanueldada.autobodyworkshop.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

public class UserDto implements Serializable {

    private int id;

    private String email;

    private String username;

    private String password;

    private LocalDate accountCreatedAt;

    private String phoneNumber;

    //NO Argument Constructor
    public UserDto(){

    }

    public UserDto(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.accountCreatedAt = user.getAccountCreatedAt();
        this.phoneNumber = user.getPhoneNumber();
    }

    //Getters & Setters for UserDto Class
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getAccountCreatedAt() {
        return accountCreatedAt;
    }

    public void setAccountCreatedAt(LocalDate accountCreatedAt) {
        this.accountCreatedAt = accountCreatedAt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
