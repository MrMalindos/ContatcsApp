package com.sheygam.loginarchitectureexample.di.application;

import com.sheygam.loginarchitectureexample.di.addContact.AddContactComponent;
import com.sheygam.loginarchitectureexample.di.addContact.AddContactModule;
import com.sheygam.loginarchitectureexample.di.contactList.ContactsListComponent;
import com.sheygam.loginarchitectureexample.di.contactList.ContactsListModule;
import com.sheygam.loginarchitectureexample.di.contactdescription.ContactDescriptionComponent;
import com.sheygam.loginarchitectureexample.di.contactdescription.ContactDescriptionModule;
import com.sheygam.loginarchitectureexample.di.login.LoginComponent;
import com.sheygam.loginarchitectureexample.di.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gregorysheygam on 30/12/2017.
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    LoginComponent plus(LoginModule loginModule);
    ContactDescriptionComponent plus(ContactDescriptionModule contactDescriptionModule);
    AddContactComponent plus(AddContactModule addContactModule);
    ContactsListComponent plus(ContactsListModule contactsListModule);

}
