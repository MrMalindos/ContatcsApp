package com.sheygam.loginarchitectureexample.di.addContact;


import com.sheygam.loginarchitectureexample.presentation.addContact.view.AddContactActivity;


import dagger.Subcomponent;

/**
 * Created by Kate on 18.02.2018.
 */

@Subcomponent(modules = {AddContactModule.class})
@AddContactScope
public interface AddContactComponent {
    void inject(AddContactActivity addContactActivity);

}
