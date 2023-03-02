package com.emmanueldada.autobodyworkshop.dtos;

import com.emmanueldada.autobodyworkshop.entites.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto implements Serializable {
    private Long id;



    private String reason_for_repair;

    //
    private UserDto userDto;




    public VehicleDto(Vehicle vehicle){
        if (vehicle.getId() != null){
            this.id = vehicle.getId();
        }

        if (vehicle.getReason_for_repair() != null){
            this.reason_for_repair = vehicle.getReason_for_repair();
        }

    }
}
