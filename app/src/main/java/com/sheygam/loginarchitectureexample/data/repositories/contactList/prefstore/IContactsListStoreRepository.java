package com.sheygam.loginarchitectureexample.data.repositories.contactList.prefstore;

/**
 * Created by Gleb on 16.02.2018.
 */

public interface IContactsListStoreRepository {
    String getAuthToken();
    void clearAuthToken();
}
