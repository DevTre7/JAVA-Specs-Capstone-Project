package com.emmanueldada.autobodyworkshop.controllers;

import com.emmanueldada.autobodyworkshop.dtos.ServiceFormDto;
import com.emmanueldada.autobodyworkshop.services.ServiceFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/service-form")
public class ServiceFormController {

@Autowired
private ServiceFormService serviceFormService;

//Add a new ServiceForm
    @PostMapping("/user/{userId}")
    public void addServiceForm(@RequestBody ServiceFormDto serviceFormDto, @PathVariable Long userId){
        serviceFormService.addServiceForm(serviceFormDto, userId);
    }
    //Delete a ServiceForm
    @DeleteMapping("/{ServiceFormId}")
    public void deleteServiceFormById(@PathVariable Long serviceFormId){
        serviceFormService.deleteServiceFormById(serviceFormId);
    }

    //Update an existing ServiceForm
    @PutMapping
    public void updateServiceForm(@RequestBody ServiceFormDto serviceFormDto){
        serviceFormService.updateServiceFormById(serviceFormDto);
    }

    //Get a ServiceForm by the ServiceForm's id
    @GetMapping("/{ServiceFormId}")
    public Optional<ServiceFormDto> getServiceFormById(@PathVariable Long serviceFormId){
        return serviceFormService.getServiceFormById(serviceFormId);
    }

}
