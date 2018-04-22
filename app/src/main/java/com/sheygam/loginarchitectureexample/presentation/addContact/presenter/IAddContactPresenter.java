package com.sheygam.loginarchitectureexample.presentation.addContact.presenter;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.presentation.addContact.view.AddContactActivity;

/**
 * Created by Kate on 17.02.2018.
 */

public interface IAddContactPresenter {


    void bindView(AddContactActivity addContactActivity);

  void unbindView(AddContactActivity addContactActivity);

  void onDoneItemSelected(String name, String email, String phone, String address, String description);
}
