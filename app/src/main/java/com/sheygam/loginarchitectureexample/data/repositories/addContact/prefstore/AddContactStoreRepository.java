package com.sheygam.loginarchitectureexample.data.repositories.addContact.prefstore;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kate on 17.02.2018.
 */

public class AddContactStoreRepository implements IAddContactStoreRepository {

    private Context context;


    public AddContactStoreRepository(Context context) {

        this.context = context;
    }

    @Override
    public String getAuthToken() {
        return context.getSharedPreferences("AUTH", Context.MODE_PRIVATE).getString("TOKEN", null);
    }
}
