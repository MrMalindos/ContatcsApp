package com.sheygam.loginarchitectureexample;

import android.app.Application;

import com.sheygam.loginarchitectureexample.di.addContact.AddContactComponent;
import com.sheygam.loginarchitectureexample.di.addContact.AddContactModule;
import com.sheygam.loginarchitectureexample.di.application.AppComponent;
import com.sheygam.loginarchitectureexample.di.application.AppModule;
import com.sheygam.loginarchitectureexample.di.application.DaggerAppComponent;
import com.sheygam.loginarchitectureexample.di.contactList.ContactsListComponent;
import com.sheygam.loginarchitectureexample.di.contactList.ContactsListModule;
import com.sheygam.loginarchitectureexample.di.contactdescription.ContactDescriptionComponent;
import com.sheygam.loginarchitectureexample.di.contactdescription.ContactDescriptionModule;
import com.sheygam.loginarchitectureexample.di.login.LoginComponent;
import com.sheygam.loginarchitectureexample.di.login.LoginModule;

/**
 * Created by gregorysheygam on 30/12/2017.
 */

public class App extends Application {
    private AppComponent component;
    private LoginComponent loginComponent;
    private ContactDescriptionComponent contactDescriptionComponent;
    private AddContactComponent addContactComponent;
    private ContactsListComponent contactsListComponent;
    private static App app;

    public App() {
        app = this;
    }

    public static App get() {
        return app;
    }

    @Override
    public void onCreate() {
        component = prepareComponent();
        super.onCreate();
    }

    private AppComponent prepareComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent applicationComponent() {
        return component;
    }

    public LoginComponent plusLoginModule(LoginModule loginModule) {
        if (loginComponent == null) {
            loginComponent = applicationComponent().plus(loginModule);
        }
        return loginComponent;
    }

    public ContactDescriptionComponent plusContactDescriptionModule(ContactDescriptionModule contactDescriptionModule) {
        if (contactDescriptionComponent == null) {
            contactDescriptionComponent = applicationComponent().plus(contactDescriptionModule);
        }
        return contactDescriptionComponent;
    }

    public AddContactComponent plusAddContactModule(AddContactModule addContactModule) {
        if (addContactComponent == null) {
            addContactComponent = applicationComponent().plus(addContactModule);
        }
        return addContactComponent;
    }

    public ContactsListComponent plusContactsListModule(ContactsListModule contactsListModule) {
        if (contactsListComponent == null) {
            contactsListComponent = applicationComponent().plus(contactsListModule);
        }
        return contactsListComponent;
    }

    public void clearContactsListComponent() {
        contactsListComponent = null;
    }

    public void clearAddContactComponent() {
        addContactComponent = null;
    }

    public void clearContactDescriptionComponent() {
        contactDescriptionComponent = null;
    }

    public void clearLoginComponent() {
        loginComponent = null;
    }
}
