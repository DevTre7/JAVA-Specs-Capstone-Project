package com.emmanueldada.autobodyworkshop.repositories;


import com.emmanueldada.autobodyworkshop.entites.User;
import com.emmanueldada.autobodyworkshop.entites.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByUserEquals(User user);
}
