package com.emmanueldada.autobodyworkshop.entites;

import com.emmanueldada.autobodyworkshop.dtos.VehicleDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Column(columnDefinition = "text")
    private String reason_for_repair;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Vehicle(VehicleDto vehicleDto){

        if (vehicleDto.getId() != null){
            this.id = vehicleDto.getId();
        }

        if (vehicleDto.getReason_for_repair() != null){
            this.reason_for_repair = vehicleDto.getReason_for_repair();
        }
    }

}
