package com.sheygam.loginarchitectureexample.presentation.contactdescription.presenter;

import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.presentation.contactdescription.view.IContactDescriptionView;
import com.sheygam.loginarchitectureexample.presentation.login.view.ILoginView;

/**
 * Created by Juli7 on 16.02.2018.
 */

public interface IContactDescriptionPresenter {

    void bindView(IContactDescriptionView view);
    void unbindView();
    void initialize(Contact contact);
//    void onEditItemSelected();
//    void onDoneItemSelected();
    void onDeleteItemSelected();

}
