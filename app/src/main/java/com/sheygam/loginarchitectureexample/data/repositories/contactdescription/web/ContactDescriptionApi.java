package com.sheygam.loginarchitectureexample.data.repositories.contactdescription.web;

import com.sheygam.loginarchitectureexample.data.dao.ContactId;
import com.sheygam.loginarchitectureexample.data.dao.Message;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Juli7 on 17.02.2018.
 */

public interface ContactDescriptionApi {

    @POST("_ah/api/contactsApi/v1/contact")
    Single<Response<Void>> removeContact(@Body ContactId contactId, @Header("Authorization") String token);
}
