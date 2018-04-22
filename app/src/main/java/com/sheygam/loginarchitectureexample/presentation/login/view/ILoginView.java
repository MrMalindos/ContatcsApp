package com.sheygam.loginarchitectureexample.presentation.login.view;

/**
 * Created by gregorysheygam on 27/12/2017.
 */

public interface ILoginView {
    void showContactsListScreen();
    void showProgress();
    void hideProgress();
    void showError(String error);
    void invalidPassword();
    void invalidEmail();
}
