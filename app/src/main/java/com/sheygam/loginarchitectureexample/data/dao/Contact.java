
package com.sheygam.loginarchitectureexample.data.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Contact {

    @SerializedName("contactId")
    @Expose
    private Long contactId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("address")
    @Expose
    private String address;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
