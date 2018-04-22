package com.sheygam.loginarchitectureexample.presentation.addContact.presenter;

import com.sheygam.loginarchitectureexample.business.addContact.IAddContactInteractor;
import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.presentation.addContact.view.AddContactActivity;
import com.sheygam.loginarchitectureexample.presentation.addContact.view.IAddContactView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kate on 17.02.2018.
 */

 public class AddContactPresenter implements IAddContactPresenter {
    private IAddContactView iAddContactView;
    private IAddContactInteractor iAddContactInteractor;

    public AddContactPresenter(IAddContactInteractor iAddContactInteractor) {
        this.iAddContactInteractor = iAddContactInteractor;
    }



    @Override
    public void bindView(AddContactActivity addContactActivity) {
        iAddContactView= addContactActivity;
    }


    @Override
    public void unbindView(AddContactActivity addContactActivity) {
        iAddContactView=null;
    }

    @Override
    public void onDoneItemSelected(String name, String email, String phone, String address, String description) {
        iAddContactView.showProgress();
        Contact contact=new Contact();
        contact.setFullName(name);
        contact.setEmail(email);
        contact.setPhoneNumber(phone);
        contact.setAddress(address);
        contact.setDescription(description);
        iAddContactInteractor.saveContact(contact)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess,throwable -> onError(throwable.getMessage()));
    }


    public void onSuccess() {

        if (iAddContactView != null) {
            iAddContactView.hideProgress();
            iAddContactView.hideAddContactScreen();
        }

    }

    public void onError(final String error) {

        if (iAddContactView != null) {
            iAddContactView.hideProgress();
            iAddContactView.showError(error);
        }

    }
}
