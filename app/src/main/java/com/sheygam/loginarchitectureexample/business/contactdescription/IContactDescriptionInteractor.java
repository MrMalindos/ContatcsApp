package com.sheygam.loginarchitectureexample.business.contactdescription;

import com.sheygam.loginarchitectureexample.data.dao.Contact;

import io.reactivex.Completable;

/**
 * Created by Juli7 on 17.02.2018.
 */

public interface IContactDescriptionInteractor {

    Completable deleteContact(Contact contact);

}
