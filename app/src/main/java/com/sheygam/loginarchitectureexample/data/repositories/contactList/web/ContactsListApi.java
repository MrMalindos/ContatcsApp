package com.sheygam.loginarchitectureexample.data.repositories.contactList.web;

import com.sheygam.loginarchitectureexample.data.dao.Contacts;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Gleb on 17.02.2018.
 */

public interface ContactsListApi {
    @GET("_ah/api/contactsApi/v1/contactsarray")
    Single<Response<Contacts>> loadList(@Header("Authorization")String token);
}
