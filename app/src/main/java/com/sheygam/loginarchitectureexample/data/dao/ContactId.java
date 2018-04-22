
package com.sheygam.loginarchitectureexample.data.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactId {

    @SerializedName("contactId")
    @Expose
    private Long contactId;

    public ContactId(Long contactId) {
        this.contactId = contactId;
    }

    public ContactId() {
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

}
