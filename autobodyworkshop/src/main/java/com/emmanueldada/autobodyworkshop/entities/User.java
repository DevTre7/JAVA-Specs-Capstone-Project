package com.emmanueldada.autobodyworkshop.entities;

import com.emmanueldada.autobodyworkshop.dtos.UserDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private LocalDate accountCreatedAt;

    @Column
    private String phoneNumber;

    //Constructor w/ NO argument
    public User(){

    }

    //Constructor that takes in UserDto Argrument
    public User(UserDto userDto){
        this.id = userDto.getId();
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.accountCreatedAt = userDto.getAccountCreatedAt();
        this.phoneNumber = userDto.getPhoneNumber();
    }

    //Auto Generated Getter & Setters for User entities Class
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
