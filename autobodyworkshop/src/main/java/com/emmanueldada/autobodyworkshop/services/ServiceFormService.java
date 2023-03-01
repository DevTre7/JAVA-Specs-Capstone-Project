package com.emmanueldada.autobodyworkshop.services;

import com.emmanueldada.autobodyworkshop.dtos.ServiceFormDto;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface ServiceFormService {
    @Transactional
    void addServiceForm(ServiceFormDto serviceFormDto, Long userId);

    @Transactional
    void deleteServiceFormById(Long serviceFormId);

    @Transactional
    void updateServiceFormById(ServiceFormDto serviceFormDto);

    Optional<ServiceFormDto> getServiceFormById(Long serviceFormId);
}
