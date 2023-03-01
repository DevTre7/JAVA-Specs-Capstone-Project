package com.emmanueldada.autobodyworkshop.services;

import com.emmanueldada.autobodyworkshop.dtos.ServiceFormDto;
import com.emmanueldada.autobodyworkshop.entites.ServiceForm;
import com.emmanueldada.autobodyworkshop.entites.User;
import com.emmanueldada.autobodyworkshop.repositories.ServiceFormRepository;
import com.emmanueldada.autobodyworkshop.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceFormServiceImpl implements ServiceFormService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceFormRepository serviceFormRepository;


    //CRUD Operations!!!

    @Override
    @Transactional
    public void addServiceForm(ServiceFormDto serviceFormDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        ServiceForm serviceForm = new ServiceForm(serviceFormDto);
        userOptional.ifPresent(serviceForm::setUser);
        serviceFormRepository.saveAndFlush(serviceForm);

    }

    @Override
    @Transactional
    public void deleteServiceFormById(Long serviceFormId){
        Optional<ServiceForm> serviceFormOptional = serviceFormRepository.findById(serviceFormId);
        serviceFormOptional.ifPresent(serviceForm -> serviceFormRepository.delete(serviceForm));
    }


    @Override
    @Transactional
    public void updateServiceFormById(ServiceFormDto serviceFormDto){
        Optional<ServiceForm> serviceFormOptional = serviceFormRepository.findById(serviceFormDto.getId());
        serviceFormOptional.ifPresent(serviceForm -> {
            serviceForm.setCustomerticketnumber(serviceForm.getCustomerticketnumber());
            serviceForm.setRepairstatus(serviceForm.getRepairstatus());
            serviceForm.setRepairtime(serviceForm.getRepairtime());
            serviceForm.setStarrating(serviceFormDto.getStarrating());
            serviceFormRepository.saveAndFlush(serviceForm);
        });

    }
    @Override
    public Optional<ServiceFormDto> getServiceFormById(Long serviceFormId){
        Optional<ServiceForm> serviceFormOptional  = serviceFormRepository.findById(serviceFormId);
        if(serviceFormOptional.isPresent()){
            return Optional.of(new ServiceFormDto(serviceFormOptional.get()));
        }
        return  Optional.empty();

    }
}
