package com.sheygam.loginarchitectureexample.di.contactList;

import android.content.Context;

import com.sheygam.loginarchitectureexample.business.contactList.ContactsListInteractor;
import com.sheygam.loginarchitectureexample.business.contactList.IContactsListInteractor;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.prefstore.ContactsListStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.prefstore.IContactsListStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.web.ContactsListApi;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.web.ContactsListWebRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactList.web.IContactsListWebRepository;
import com.sheygam.loginarchitectureexample.presentation.contactsList.presenter.ContactsListPresenter;
import com.sheygam.loginarchitectureexample.presentation.contactsList.presenter.IContactsListPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Gleb on 18.02.2018.
 */
@Module
public class ContactsListModule {

    @Provides
    @ContatctsListScope
    IContactsListWebRepository provideWebRepository(Retrofit retrofit) {
        return new ContactsListWebRepository(retrofit.create(ContactsListApi.class));
    }

    @Provides
    @ContatctsListScope
    IContactsListStoreRepository provideStroreRepository(Context context) {
        return new ContactsListStoreRepository(context);
    }

    @Provides
    @ContatctsListScope
    IContactsListInteractor provideLoginInteractor(IContactsListWebRepository webRepository, IContactsListStoreRepository storeRepository) {
        return new ContactsListInteractor(webRepository, storeRepository);
    }

    @Provides
    @ContatctsListScope
    IContactsListPresenter provideLoginPresenter() {
        return new ContactsListPresenter();
    }
}
