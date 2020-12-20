package com.codegym.entities.customer_entity;

import com.codegym.entities.contact_entity.Contact;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name", nullable = false, unique = true)
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String birthDay;

    @Column(name = "customer_gender", columnDefinition = "BIT")
    private int gender;

    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(45)", unique = true)
    private String idCardNum;

    @Column(name = "customer_phone", columnDefinition = "VARCHAR(45)")
    private String phoneNumber;

    @Column(name = "customer_email", columnDefinition = "VARCHAR(45)",unique = true)
    private String email;

    @Column(name = "customer_address", columnDefinition = "VARCHAR(45)")
    private String address;

    @ManyToOne()
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Contact> contact;
    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }
}
