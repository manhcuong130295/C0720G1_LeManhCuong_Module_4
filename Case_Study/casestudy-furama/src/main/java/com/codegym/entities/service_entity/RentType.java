package com.codegym.entities.service_entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private int rentTypeId;

    @Column(name = "rent_type_name",columnDefinition = "VARCHAR(45)")
    private String rentTypename;

    @Column(name = "rent_type_cost")
    private double renTypeCost;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    List<Service> service;

    public RentType() {
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypename() {
        return rentTypename;
    }

    public void setRentTypename(String rentTypename) {
        this.rentTypename = rentTypename;
    }

    public double getRenTypeCost() {
        return renTypeCost;
    }

    public void setRenTypeCost(double renTypeCost) {
        this.renTypeCost = renTypeCost;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

}
