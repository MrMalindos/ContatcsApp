package com.sheygam.loginarchitectureexample.data.repositories.contactList.web;

import com.sheygam.loginarchitectureexample.data.dao.Contacts;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.prefstore.IContactsListStoreRepository;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Gleb on 16.02.2018.
 */

public class ContactsListWebRepository implements IContactsListWebRepository {
    private ContactsListApi listApi;

    public ContactsListWebRepository(ContactsListApi listApi) {
        this.listApi = listApi;
    }

    @Override
    public Single<Contacts> loadList(String token) {
        return listApi.loadList(token)
                .doOnError(throwable -> {
                    throw new Exception("Connection error!");
                })
                .map(this::handleLoadResponse);
    }

    private Contacts handleLoadResponse(Response<Contacts> response) throws Exception {
        if (response.isSuccessful()) {
            return response.body();
        } else if (response.code() == 401) {
            throw new Exception("Wrong authorization! empty token");
        } else {
            throw new Exception("Server error!");
        }
    }
}
