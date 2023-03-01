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

    private String customer_name;

    private String vehicle_type;

    private String make;

    private  String model;

    private String reason_for_repair;

    //
    private UserDto userDto;




    public VehicleDto(Vehicle vehicle){
        if (vehicle.getId() != null){
            this.id = vehicle.getId();
        }
        if (vehicle.getCustomer_name() != null){
            this.customer_name = vehicle.getCustomer_name();
        }
        if (vehicle.getVehicle_type() != null){
            this.vehicle_type = vehicle.getVehicle_type();
        }
        if (vehicle.getMake() != null){
            this.make = vehicle.getMake();
        }
        if (vehicle.getModel() != null){
            this.model = vehicle.getModel();
        }
        if (vehicle.getReason_for_repair() != null){
            this.reason_for_repair = vehicle.getReason_for_repair();
        }

    }
}
