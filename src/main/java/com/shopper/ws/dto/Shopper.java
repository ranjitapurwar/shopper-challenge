package com.shopper.ws.dto;

import java.io.Serializable;

/**
 * Created by rpurwar on 5/22/18.
 */
public class Shopper implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long shopperId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private Integer zipCode;


    public Long getShopperId() {
        return shopperId;
    }

    public void setShopperId(Long shopperId) {

        this.shopperId = shopperId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
