package com.emmanueldada.autobodyworkshop.controllers;


import com.emmanueldada.autobodyworkshop.dtos.VehicleDto;
import com.emmanueldada.autobodyworkshop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    //Get All Vehicles By User
    @GetMapping("/user/{userId}")
    public List<VehicleDto> getVehicleByUser(@PathVariable Long userId){
        return vehicleService.getAllVehicleByUserId(userId);
    }

    //Add a new Vehicle
    @PostMapping("/user/{userId}")
    public void addVehicle(@RequestBody VehicleDto vehicleDto, @PathVariable Long userId){
        vehicleService.addVehicle(vehicleDto, userId);
    }

    //Delete a Vehicle
    @DeleteMapping("/{VehicleId}")
    public void deleteVehicleById(@PathVariable Long vehicleId){
        vehicleService.deleteVehicleById(vehicleId);
    }

    //Update an existing Vehicle
    @PutMapping
    public void updateVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.updateVehicleById(vehicleDto);
    }

    //Get a Vehicle by the Vehicle's id
    @GetMapping("/{VehicleId}")
    public Optional<VehicleDto> getVehicleById(@PathVariable Long vehicleId){
        return vehicleService.getVehicleById(vehicleId);
    }

}
