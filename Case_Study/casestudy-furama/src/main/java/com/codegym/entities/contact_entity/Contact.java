package com.codegym.entities.contact_entity;

import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.service_entity.Service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int idContact;

    @Column(name = "contact_start_date", columnDefinition = "DATE")
    private String startDate;

    @Column(name = "contact_end_date", columnDefinition = "DATE")
    private String endDate;

    @Column(name = "contact_deposit")
    private double deposit;

    @Column(name = "contact_total_money")
    private double totalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
    private List<ContactDetail> contactDetail;

    public Contact() {
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int id) {
        this.idContact = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContactDetail> getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(List<ContactDetail> contactDetail) {
        this.contactDetail = contactDetail;
    }

}
