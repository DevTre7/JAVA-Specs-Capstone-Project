package com.emmanueldada.autobodyworkshop.dtos;

import com.emmanueldada.autobodyworkshop.entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String password;

    private String email;

    private LocalDate createdat;

    private String phone;

    private Set<VehicleDto> vehicleDtoSet = new HashSet<>();

    public UserDto(User user) {
        if (user.getId() != null){
            this.id = user.getId();
        }
        if (user.getUsername() != null){
            this.username = user.getUsername();
        }
        if (user.getPassword() != null){
            this.password = user.getPassword();
        }

        if (user.getEmail() != null){
            this.email = user.getEmail();
        }
        if (user.getCreatedat() != null){
            this.createdat = user.getCreatedat();
        }
        if (user.getPhone()!= null){
            this.phone = user.getPhone();
        }
    }
}
