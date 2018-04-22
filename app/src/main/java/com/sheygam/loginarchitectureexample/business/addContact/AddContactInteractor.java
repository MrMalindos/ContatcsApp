package com.sheygam.loginarchitectureexample.business.addContact;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.data.repositories.addContact.prefstore.IAddContactStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.addContact.web.IAddContactWebRepository;

import io.reactivex.Completable;

/**
 * Created by Kate on 17.02.2018.
 */

 public class AddContactInteractor implements IAddContactInteractor {
        private IAddContactWebRepository iAddContactWebRepository;
        private IAddContactStoreRepository iAddContactStoreRepository;


    public AddContactInteractor(IAddContactWebRepository iAddContactWebRepository, IAddContactStoreRepository iAddContactStoreRepository) {
        this.iAddContactWebRepository = iAddContactWebRepository;
        this.iAddContactStoreRepository = iAddContactStoreRepository;
    }


    private String getFromRep() {
        return iAddContactStoreRepository.getAuthToken();
    }


    @Override
    public Completable saveContact(Contact contact) {
        return iAddContactWebRepository.saveContact(getFromRep(), contact)
                .toCompletable();
    }
}
