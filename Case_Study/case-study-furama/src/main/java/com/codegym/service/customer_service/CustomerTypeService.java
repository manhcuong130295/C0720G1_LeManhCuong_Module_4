package com.codegym.service.customer_service;

import com.codegym.entities.customer_entity.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}
