package com.sheygam.loginarchitectureexample.presentation.contactsList.presenter;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.presentation.contactsList.view.IContactsListView;

/**
 * Created by Gleb on 16.02.2018.
 */

public interface IContactsListPresenter {
    void initialize();
    void onAddContactButtonClicked();
    void onContactItemSelected(Contact contact);
    void onLogOutItemSelected();
}
