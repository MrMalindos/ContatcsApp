package com.sheygam.loginarchitectureexample.di.contactdescription;

import android.content.Context;

import com.sheygam.loginarchitectureexample.business.contactdescription.ContactDescriptionInteractor;
import com.sheygam.loginarchitectureexample.business.contactdescription.IContactDescriptionInteractor;
import com.sheygam.loginarchitectureexample.data.repositories.contactdescription.prefstore.ContactDescriptionStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactdescription.prefstore.IContactDescriptionStoreRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactdescription.web.ContactDescriptionApi;
import com.sheygam.loginarchitectureexample.data.repositories.contactdescription.web.ContactDescriptionRetrofitRepository;
import com.sheygam.loginarchitectureexample.data.repositories.contactdescription.web.IContactDescriptionWebRepository;
import com.sheygam.loginarchitectureexample.presentation.contactdescription.presenter.ContactDescriptionPresenter;
import com.sheygam.loginarchitectureexample.presentation.contactdescription.presenter.IContactDescriptionPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Juli7 on 18.02.2018.
 */

@Module
public class ContactDescriptionModule {

    @Provides
    @ContactDescriptionScope
    IContactDescriptionWebRepository provideWebRepository(Retrofit retrofit){
        return new ContactDescriptionRetrofitRepository(retrofit.create(ContactDescriptionApi.class));
    }

    @Provides
    @ContactDescriptionScope
    IContactDescriptionStoreRepository provideStoreRepository(Context context){
        return new ContactDescriptionStoreRepository(context);
    }

    @Provides
    @ContactDescriptionScope
    IContactDescriptionInteractor provideInteractor(IContactDescriptionWebRepository webRepository, IContactDescriptionStoreRepository storeRepository){
        return new ContactDescriptionInteractor(webRepository,storeRepository);
    }

    @Provides
    @ContactDescriptionScope
    IContactDescriptionPresenter providePresenter(IContactDescriptionInteractor interactor){
        return new ContactDescriptionPresenter(interactor);
    }
}
