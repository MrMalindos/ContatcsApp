package com.sheygam.loginarchitectureexample.data.repositories.contactList.web;

import com.sheygam.loginarchitectureexample.data.dao.Contacts;

import io.reactivex.Single;

/**
 * Created by Gleb on 16.02.2018.
 */

public interface IContactsListWebRepository {
    Single<Contacts> loadList(String token);
}
