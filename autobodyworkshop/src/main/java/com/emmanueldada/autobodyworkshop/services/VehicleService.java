package com.emmanueldada.autobodyworkshop.services;



import com.emmanueldada.autobodyworkshop.dtos.VehicleDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<VehicleDto> getAllVehicleByUserId(Long userId);

    @Transactional
    void addVehicle(VehicleDto vehicleDto, Long userId);

    @Transactional
    void deleteVehicleById(Long VehicleId);

    @Transactional
    void updateVehicleById(VehicleDto vehicleDto);

    Optional<VehicleDto> getVehicleById(Long vehicleId);
}
