package com.sheygam.loginarchitectureexample.business.addContact;

import com.sheygam.loginarchitectureexample.data.dao.Contact;

import io.reactivex.Completable;


/**
 * Created by Kate on 17.02.2018.
 */

public interface IAddContactInteractor {




    Completable saveContact(Contact contact);
}
