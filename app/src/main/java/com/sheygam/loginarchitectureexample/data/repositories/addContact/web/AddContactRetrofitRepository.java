package com.sheygam.loginarchitectureexample.data.repositories.addContact.web;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Kate on 18.02.2018.
 */

public class AddContactRetrofitRepository implements IAddContactWebRepository {
    private SaveApi saveApi;

    public AddContactRetrofitRepository(SaveApi saveApi) {
        this.saveApi = saveApi;
    }




    private String handleSaveResponse(Response<Void> response) throws Exception {
        if(response.isSuccessful()){
            return response.message();
        }
        else if(response.code() == 401){
            throw new Exception("Wrong contact!");
        }else{
            throw new Exception("Server error");
        }
    }


    @Override
    public Single<String> saveContact(String token, Contact contact) {
        return saveApi.saveContact(contact, token)
                .doOnError(throwable -> {throw new Exception("Connection error!");})
                .map(this::handleSaveResponse);
    }


}

