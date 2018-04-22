package com.sheygam.loginarchitectureexample.presentation.contactdescription.view;

/**
 * Created by Juli7 on 16.02.2018.
 */

public interface IContactDescriptionView {


    void showLoading();
    void hideLoading();
    void showRemoveContactError(String error);
    void hideContactDescriptionScreen();
    void setActionBarTitle(String title);
    void setContactFullName(String name);
    void setContactEmail(String email);
    void setContactPhoneNumber(String phoneNumber);
    void setContactAddress(String address);
    void setContactDescription(String desc);
//    void showEditContactView();
//    void hideEditContactView();
}
