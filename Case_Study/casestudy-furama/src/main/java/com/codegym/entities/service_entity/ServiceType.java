package com.codegym.entities.service_entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private int serviceTypeId;

    @Column(name = "service_name")
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private List<Service> service;

    public ServiceType() {
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

}
