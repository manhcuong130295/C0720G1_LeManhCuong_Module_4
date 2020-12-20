package com.codegym.service.customer_service.impl;

import com.codegym.entities.customer_entity.CustomerType;
import com.codegym.repository.customer_repository.CustomerTypeRepository;
import com.codegym.service.customer_service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeRepository.findAll();
    }
}
