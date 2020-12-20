package com.codegym.entities.contact_entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private int idAttachService;

    @Column(name = "attach_service_name", columnDefinition = "VARCHAR(45)")
    private String attachServiceName;

    @Column(name = "attach_service_cost")
    private double attachServiceCost;

    @Column(name = "attach_service_unit")
    private int attachServiceUnit;

    @Column(name = "attach_service_status",columnDefinition = "VARCHAR(45)")
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    private List<AttachService> attachService;

    public AttachService() {
    }

    public int getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(int idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public List<AttachService> getAttachService() {
        return attachService;
    }

    public void setAttachService(List<AttachService> attachService) {
        this.attachService = attachService;
    }

}

