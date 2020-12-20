package com.codegym.service.service_service.impl;

import com.codegym.entities.service_entity.RentType;
import com.codegym.entities.service_entity.Service;
import com.codegym.entities.service_entity.ServiceType;
import com.codegym.repository.service_repository.RentTypeRepository;
import com.codegym.repository.service_repository.ServiceRepository;
import com.codegym.repository.service_repository.ServiceTypeRepository;
import com.codegym.service.service_service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return this.serviceRepository.findAll(pageable);
    }

    @Override
    public void save(Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public Service findById(int id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.serviceRepository.deleteById(id);
    }

    @Override
    public List<RentType> findAllRenType() {
        return this.rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return this.serviceTypeRepository.findAll();
    }
}
