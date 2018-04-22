package com.sheygam.loginarchitectureexample.data.repositories.contactList.prefstore;

import android.content.Context;

/**
 * Created by Gleb on 16.02.2018.
 */

public class ContactsListStoreRepository implements IContactsListStoreRepository {
    private Context context;

    public ContactsListStoreRepository(Context context) {
        this.context = context;
    }

    @Override
    public String getAuthToken() {
        return context.getSharedPreferences("AUTH", Context.MODE_PRIVATE).getString("TOKEN", null);
    }

    @Override
    public void clearAuthToken() {
        context.getSharedPreferences("AUTH", Context.MODE_PRIVATE).edit().clear().apply();
    }
}
