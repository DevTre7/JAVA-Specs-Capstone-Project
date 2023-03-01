package com.emmanueldada.autobodyworkshop.services;


import com.emmanueldada.autobodyworkshop.dtos.VehicleDto;
import com.emmanueldada.autobodyworkshop.entites.User;
import com.emmanueldada.autobodyworkshop.entites.Vehicle;
import com.emmanueldada.autobodyworkshop.repositories.UserRepository;
import com.emmanueldada.autobodyworkshop.repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<VehicleDto> getAllVehicleByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Vehicle> vehicleList = vehicleRepository.findAllByUserEquals(userOptional.get());
            return vehicleList.stream().map(vehicle -> new VehicleDto(vehicle)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addVehicle(VehicleDto vehicleDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Vehicle vehicle = new Vehicle(vehicleDto);
        userOptional.ifPresent(vehicle::setUser);
        vehicleRepository.saveAndFlush(vehicle);
    }

    @Override
    @Transactional
    public void deleteVehicleById(Long VehicleId) {
        Optional<Vehicle> noteOptional = vehicleRepository.findById(VehicleId);
        noteOptional.ifPresent(vehicle -> vehicleRepository.delete(vehicle));
    }

    @Override
    @Transactional
    public void updateVehicleById(VehicleDto vehicleDto) {
        Optional<Vehicle> noteOptional = vehicleRepository.findById(vehicleDto.getId());
        noteOptional.ifPresent(vehicle -> {
            vehicle.setReason_for_repair(vehicleDto.getReason_for_repair());
            vehicleRepository.saveAndFlush(vehicle);
        });
    }

    @Override
    public Optional<VehicleDto> getVehicleById(Long vehicleId) {
        Optional<Vehicle> noteOptional = vehicleRepository.findById(vehicleId);
        if (noteOptional.isPresent()){
            return Optional.of(new VehicleDto(noteOptional.get()));
        }
        return Optional.empty();
    }
}
