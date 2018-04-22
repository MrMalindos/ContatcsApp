package com.sheygam.loginarchitectureexample.data.repositories.addContact.web;

import com.sheygam.loginarchitectureexample.data.dao.Auth;
import com.sheygam.loginarchitectureexample.data.dao.AuthToken;
import com.sheygam.loginarchitectureexample.data.dao.Contact;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Kate on 18.02.2018.
 */

public interface SaveApi {
    @POST("_ah/api/contactsApi/v1/setContact")
    Single<Response<Void>> saveContact(@Body Contact contact, @Header("Authorization") String token);
}
