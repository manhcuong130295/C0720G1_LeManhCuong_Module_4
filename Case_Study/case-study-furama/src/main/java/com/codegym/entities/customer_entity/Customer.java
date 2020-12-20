package com.codegym.entities.customer_entity;

import com.codegym.entities.contact_entity.Contact;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @NotBlank
    @Size(min = 5, max = 45, message = "full name must have minimum of 5 and maximum 45 character")
    @Pattern(regexp = "^([A-Z]([a-z])*)(\\s[A-Z][a-z]*)*$", message = "wrong format full name!")
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String birthDay;


    @Column(name = "customer_gender", columnDefinition = "INT")
    private int gender;

    @Pattern(regexp = "\\d{3}\\s\\d{3}\\s\\d{3}", message = "Wrong format Id Card Number! Id Card Number must have format xxx xxx xxx (x=0-9)")
    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(45)")
    private String idCardNum;
    @NotBlank
    @Size(min = 10, max = 11, message = "wrong format phone number")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "wrong format phone number")
    @Column(name = "customer_phone", columnDefinition = "VARCHAR(45)")
    private String phoneNumber;

    @NotBlank
    @Email(message = "wrong format email")
//    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$",message = "email must format abc@abc.com")
    @Column(name = "customer_email", columnDefinition = "VARCHAR(45)")
    private String email;

    @NotNull
    @Column(name = "customer_address", columnDefinition = "VARCHAR(45)")
    private String address;

    @ManyToOne()
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
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
