package com.sheygam.loginarchitectureexample.presentation.contactdescription.presenter;

import com.sheygam.loginarchitectureexample.business.contactdescription.IContactDescriptionInteractor;
import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.data.dao.ContactId;
import com.sheygam.loginarchitectureexample.presentation.contactdescription.view.IContactDescriptionView;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Juli7 on 16.02.2018.
 */

public class ContactDescriptionPresenter implements IContactDescriptionPresenter {
    private IContactDescriptionView view;
    private IContactDescriptionInteractor interactor;
    private Contact contact;

    public ContactDescriptionPresenter(IContactDescriptionInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void bindView(IContactDescriptionView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public void initialize(Contact contact) {
        this.contact = contact;
        setContactToView(contact);
    }

    private void setContactToView(Contact contact){
        view.setContactFullName(contact.getFullName());
        view.setContactPhoneNumber(contact.getPhoneNumber());
        view.setContactEmail(contact.getEmail());
        view.setContactAddress(contact.getAddress());
        view.setContactDescription(contact.getDescription());
        view.setActionBarTitle(contact.getFullName());
    }

    @Override
    public void onDeleteItemSelected() {
        view.showLoading();
        interactor.deleteContact(contact)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, throwable -> onError(throwable.getMessage()));
    }

    private void onSuccess(){
        view.hideLoading();
        view.hideContactDescriptionScreen();
    }

    private void onError(String error){
        view.hideLoading();
        view.showRemoveContactError(error);
    }
}
