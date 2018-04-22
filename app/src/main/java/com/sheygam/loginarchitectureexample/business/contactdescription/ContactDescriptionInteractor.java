package com.sheygam.loginarchitectureexample.business.contactdescription;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.data.dao.ContactId;
import com.sheygam.loginarchitectureexample.data.repositories.contactdescription.prefstore.IContactDescriptionStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactdescription.web.IContactDescriptionWebRepository;

import io.reactivex.Completable;

/**
 * Created by Juli7 on 17.02.2018.
 */

public class ContactDescriptionInteractor implements IContactDescriptionInteractor {
    private IContactDescriptionWebRepository webRepository;
    private IContactDescriptionStoreRepository storeRepository;

    public ContactDescriptionInteractor(IContactDescriptionWebRepository webRepository,
                                        IContactDescriptionStoreRepository storeRepository) {
        this.webRepository = webRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public Completable deleteContact(Contact contact) {
        String token = storeRepository.getToken();
        ContactId contactId = new ContactId(contact.getContactId());
        return webRepository.removeContact(contactId, token).toCompletable();
    }
}
