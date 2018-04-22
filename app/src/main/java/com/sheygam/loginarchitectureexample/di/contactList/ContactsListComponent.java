package com.sheygam.loginarchitectureexample.di.contactList;

import com.sheygam.loginarchitectureexample.presentation.contactsList.presenter.ContactsListPresenter;

import dagger.Subcomponent;

/**
 * Created by Gleb on 18.02.2018.
 */
@Subcomponent(modules = {ContactsListModule.class})
@ContatctsListScope
public interface ContactsListComponent {
    void inject(ContactsListPresenter presenter);
}
