package com.sheygam.loginarchitectureexample.business.contactList;

import com.sheygam.loginarchitectureexample.data.dao.Contact;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Gleb on 16.02.2018.
 */

public interface IContactsListInteractor {
    Single<List<Contact>> loadList();
    void logout();
}
