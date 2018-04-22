package com.sheygam.loginarchitectureexample.di.contactdescription;

import com.sheygam.loginarchitectureexample.presentation.contactdescription.view.ContactDescriptionActivity;

import dagger.Subcomponent;

/**
 * Created by Juli7 on 18.02.2018.
 */

@Subcomponent(modules = {ContactDescriptionModule.class})
@ContactDescriptionScope
public interface ContactDescriptionComponent {
    void inject(ContactDescriptionActivity contactDescriptionActivity);
}
