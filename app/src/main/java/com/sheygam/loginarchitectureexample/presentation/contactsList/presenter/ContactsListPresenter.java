package com.sheygam.loginarchitectureexample.presentation.contactsList.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.sheygam.loginarchitectureexample.App;
import com.sheygam.loginarchitectureexample.business.contactList.IContactsListInteractor;
import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.di.contactList.ContactsListModule;
import com.sheygam.loginarchitectureexample.presentation.contactsList.view.IContactsListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Gleb on 16.02.2018.
 */
@InjectViewState
public class ContactsListPresenter extends MvpPresenter<IContactsListView> implements IContactsListPresenter {
    @Inject
    IContactsListInteractor interactor;

    public ContactsListPresenter() {
        App.get().plusContactsListModule(new ContactsListModule()).inject(this);
    }
    @Override
    public void initialize() {
        getViewState().showProgress();
        interactor.loadList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, throwable -> onError(throwable.getMessage()));
    }

    @Override
    public void onAddContactButtonClicked() {
        getViewState().showAddNewContactScreen();
    }

    @Override
    public void onContactItemSelected(Contact contact) {
        getViewState().showContactDescriptionScreen(contact);
    }

    @Override
    public void onLogOutItemSelected() {
        interactor.logout();
        getViewState().hideContactsListScreen();
    }

    public void onSuccess(List<Contact> list) {
        if (getViewState() != null) {
            getViewState().hideProgress();
            if (list.size() != 0) {
                getViewState().showContactsList(list);
            } else {
                getViewState().showEmptyList();
            }
        }
    }

    public void onError(final String error) {
        if (getViewState() != null) {
            getViewState().hideProgress();
            getViewState().showError(error);
        }
    }

    @Override
    public void onDestroy() {
        App.get().clearContactsListComponent();
        super.onDestroy();
    }
}
