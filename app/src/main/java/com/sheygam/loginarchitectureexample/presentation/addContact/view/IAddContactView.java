package com.sheygam.loginarchitectureexample.presentation.addContact.view;

/**
 * Created by Kate on 17.02.2018.
 */

public interface IAddContactView {
    void showProgress();
    void hideProgress();
    void showError(String error);
    void showSuccess(String msg);
    void hideAddContactScreen();
    void initialise();

}
