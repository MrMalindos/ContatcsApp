package com.sheygam.loginarchitectureexample.presentation.contactsList.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.data.dao.Contacts;

import java.util.List;

/**
 * Created by Gleb on 16.02.2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface IContactsListView extends MvpView{
    void hideContactsListScreen();
    void showProgress();
    void hideProgress();
    void showError(String error);
    void showEmptyList();
    void showContactsList(List<Contact> list);
    void showContactDescriptionScreen(Contact contact);
    void showAddNewContactScreen();
}
