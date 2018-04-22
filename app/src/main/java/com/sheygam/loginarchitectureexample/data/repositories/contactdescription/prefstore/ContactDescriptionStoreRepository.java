package com.sheygam.loginarchitectureexample.data.repositories.contactdescription.prefstore;

import android.content.Context;

/**
 * Created by Juli7 on 17.02.2018.
 */

public class ContactDescriptionStoreRepository implements IContactDescriptionStoreRepository {
    private Context context;

    public ContactDescriptionStoreRepository(Context context) {
        this.context = context;
    }

    @Override
    public String getToken() {
        return context.getSharedPreferences("AUTH",Context.MODE_PRIVATE)
                .getString("TOKEN", null);
    }
}
