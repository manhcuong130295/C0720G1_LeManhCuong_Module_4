package com.codegym.service.service_service;

import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.service_entity.RentType;
import com.codegym.entities.service_entity.Service;
import com.codegym.entities.service_entity.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {

    Page<Service> findAll(Pageable pageable);

    void save(Service service);

    Service findById(int id);

    void remove(int id);

    List<RentType> findAllRenType();

    List<ServiceType> findAllServiceType();
}
