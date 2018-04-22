package com.sheygam.loginarchitectureexample.data.repositories.contactdescription.web;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.data.dao.ContactId;
import com.sheygam.loginarchitectureexample.data.dao.Message;

import io.reactivex.Single;

/**
 * Created by Juli7 on 17.02.2018.
 */

public interface IContactDescriptionWebRepository {
    Single<String> removeContact(ContactId contactId, String token);
}
