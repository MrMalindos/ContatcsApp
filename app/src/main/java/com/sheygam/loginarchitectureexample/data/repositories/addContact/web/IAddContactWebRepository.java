package com.sheygam.loginarchitectureexample.data.repositories.addContact.web;

import com.sheygam.loginarchitectureexample.data.dao.Contact;

import io.reactivex.Single;

/**
 * Created by Kate on 17.02.2018.
 */

public interface IAddContactWebRepository {




    Single saveContact(String token, Contact contact);
}
