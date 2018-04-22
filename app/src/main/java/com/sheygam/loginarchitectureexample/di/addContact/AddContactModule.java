package com.sheygam.loginarchitectureexample.di.addContact;

import android.content.Context;
import com.sheygam.loginarchitectureexample.business.addContact.AddContactInteractor;
import com.sheygam.loginarchitectureexample.business.addContact.IAddContactInteractor;
import com.sheygam.loginarchitectureexample.data.repositories.addContact.prefstore.AddContactStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.addContact.prefstore.IAddContactStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.addContact.web.AddContactRetrofitRepository;
import com.sheygam.loginarchitectureexample.data.repositories.addContact.web.IAddContactWebRepository;
import com.sheygam.loginarchitectureexample.data.repositories.addContact.web.SaveApi;
import com.sheygam.loginarchitectureexample.di.login.LoginScope;
import com.sheygam.loginarchitectureexample.presentation.addContact.presenter.AddContactPresenter;
import com.sheygam.loginarchitectureexample.presentation.addContact.presenter.IAddContactPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Kate on 18.02.2018.
 */
@Module
public class AddContactModule {
    @Provides
    @AddContactScope
    IAddContactWebRepository provideWebRepository(Retrofit retrofit){
        return new AddContactRetrofitRepository(retrofit.create(SaveApi.class));
    }

    @Provides
    @AddContactScope
    IAddContactStoreRepository provideStroreRepository(Context context){
        return new AddContactStoreRepository(context);
    }

    @Provides
    @AddContactScope
    IAddContactInteractor provideLoginInteractor(IAddContactWebRepository webRepository, IAddContactStoreRepository storeRepository){
        return new AddContactInteractor(webRepository,storeRepository);
    }

    @Provides
    @AddContactScope
    IAddContactPresenter provideLoginPresenter(IAddContactInteractor interactor){
        return new AddContactPresenter(interactor);
    }

}
