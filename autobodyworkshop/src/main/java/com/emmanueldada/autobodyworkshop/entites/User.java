package com.emmanueldada.autobodyworkshop.entites;

import com.emmanueldada.autobodyworkshop.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;

    @Column
    private String password;


    @Column(unique = true)
    private String email;

    @Column
    private LocalDate createdat;

    @Column
    private String phone;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Vehicle> vehicleSet = new HashSet<>();

    public User(UserDto userDto){
        if (userDto.getUsername() != null){
            this.username = userDto.getUsername();
        }
        if (userDto.getPassword() != null){
            this.password = userDto.getPassword();
        }

        if (userDto.getEmail() != null){
            this.email = userDto.getEmail();
        }
        if (userDto.getCreatedat() != null){
            this.createdat = userDto.getCreatedat();
        }
        if (userDto.getPhone()!= null){
            this.phone = userDto.getPhone();
        }
    }

}
