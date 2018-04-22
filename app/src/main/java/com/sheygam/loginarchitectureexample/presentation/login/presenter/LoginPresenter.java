package com.sheygam.loginarchitectureexample.presentation.login.presenter;

import android.util.Log;

import com.sheygam.loginarchitectureexample.business.login.EmailValidException;
import com.sheygam.loginarchitectureexample.business.login.ILoginInteractor;
import com.sheygam.loginarchitectureexample.business.login.PasswordValidException;
import com.sheygam.loginarchitectureexample.presentation.login.view.ILoginView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gregorysheygam on 27/12/2017.
 */

public class LoginPresenter implements ILoginPresenter {
    public static final String TAG = "MY_TAG";
    private ILoginView iLoginView;
    private ILoginInteractor interactor;


    public LoginPresenter(ILoginInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void bindView(ILoginView view) {
        iLoginView = view;
    }

    @Override
    public void unbindView() {
        iLoginView = null;
    }

    @Override
    public void init() {
        if (interactor.isLogin()){
            iLoginView.showContactsListScreen();
        }
    }

    @Override
    public void makeLogin(String email, String password) {
        try {
            Log.d(TAG, "makeLogin: presenter");
            iLoginView.showProgress();
            interactor.login(email,password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::onSuccess,throwable -> onError(throwable.getMessage()));

        } catch (PasswordValidException e) {
            Log.d(TAG, "makeLogin: error");
            iLoginView.hideProgress();
            iLoginView.invalidPassword();
        } catch (EmailValidException e) {
            iLoginView.hideProgress();
            iLoginView.invalidEmail();
        }
    }

    @Override
    public void makeRegistration(String email, String password) {
        try {
            Log.d(TAG, "makeRegistration: ");
            iLoginView.showProgress();
            interactor.registration(email,password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::onSuccess,throwable -> {
                        onError(throwable.getMessage());
                        throwable.printStackTrace();
                    });
        } catch (PasswordValidException e) {
            Log.d(TAG, "makeRegistration: error");
            iLoginView.hideProgress();
            iLoginView.invalidPassword();
        } catch (EmailValidException e) {
            Log.d(TAG, "makeRegistration: ");
            iLoginView.hideProgress();
            iLoginView.invalidEmail();
        }
    }

    public void onSuccess() {

        if (iLoginView != null) {
            iLoginView.hideProgress();
            iLoginView.showContactsListScreen();
        }

    }

    public void onError(final String error) {

        if (iLoginView != null) {
            iLoginView.hideProgress();
            iLoginView.showError(error);
        }

    }
}
