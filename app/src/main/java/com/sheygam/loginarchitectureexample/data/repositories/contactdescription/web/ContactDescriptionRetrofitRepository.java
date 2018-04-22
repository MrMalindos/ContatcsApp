package com.sheygam.loginarchitectureexample.data.repositories.contactdescription.web;

import com.sheygam.loginarchitectureexample.data.dao.ContactId;
import com.sheygam.loginarchitectureexample.data.dao.Message;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Juli7 on 17.02.2018.
 */

public class ContactDescriptionRetrofitRepository implements IContactDescriptionWebRepository {
    private ContactDescriptionApi contactDescriptionApi;

    public ContactDescriptionRetrofitRepository(ContactDescriptionApi contactDescriptionApi) {
        this.contactDescriptionApi = contactDescriptionApi;
    }

    @Override
    public Single<String> removeContact(ContactId contactId, String token) {
        return contactDescriptionApi.removeContact(contactId, token)
                .doOnError(throwable -> {throw new Exception("Connection error!");})
                .map(this::handleRemoveContactResponse);
    }

    private String handleRemoveContactResponse(Response<Void> response) throws Exception {
        if(response.isSuccessful()){
            return response.message();
        }else if(response.code() == 409){
            throw new Exception("User already exist!");
        }else{
            throw new Exception("Server error");
        }
    }
}
