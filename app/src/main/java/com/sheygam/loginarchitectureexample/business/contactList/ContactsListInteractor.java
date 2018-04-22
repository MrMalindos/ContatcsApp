package com.sheygam.loginarchitectureexample.business.contactList;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.data.dao.Contacts;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.prefstore.IContactsListStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.web.IContactsListWebRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by Gleb on 16.02.2018.
 */

public class ContactsListInteractor implements IContactsListInteractor {
    private IContactsListWebRepository webRepository;
    private IContactsListStoreRepository storeRepository;

    public ContactsListInteractor(IContactsListWebRepository webRepository, IContactsListStoreRepository storeRepository) {
        this.webRepository = webRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public Single<List<Contact>> loadList() {
        String token = storeRepository.getAuthToken();
        return webRepository.loadList(token)
                .map(this::mappingList);
    }

    @Override
    public void logout() {
        storeRepository.clearAuthToken();
    }

    private List<Contact> mappingList(Contacts contacts) {
        if (contacts.getContacts() == null){
            return new ArrayList<>();
        }
        return contacts.getContacts();
    }
}
