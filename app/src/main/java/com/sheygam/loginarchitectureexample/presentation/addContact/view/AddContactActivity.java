package com.sheygam.loginarchitectureexample.presentation.addContact.view;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.sheygam.loginarchitectureexample.App;
import com.sheygam.loginarchitectureexample.R;
import com.sheygam.loginarchitectureexample.di.addContact.AddContactModule;
import com.sheygam.loginarchitectureexample.di.login.LoginModule;
import com.sheygam.loginarchitectureexample.presentation.addContact.presenter.IAddContactPresenter;

import javax.inject.Inject;

/**
 * Created by Kate on 17.02.2018.
 */

public class AddContactActivity extends AppCompatActivity implements IAddContactView, View.OnClickListener {
    @Inject
    IAddContactPresenter presenter;
    private EditText nameIn, emailIn, addressIn, phoneIn, descIn;
    private FrameLayout proBar;
    private Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_add);


        App.get().plusAddContactModule(new AddContactModule()).inject(this);

        Toolbar toolbar = findViewById(R.id.add_contact_toolbar);
        setSupportActionBar(toolbar);
        nameIn = findViewById(R.id.name_input);
        emailIn = findViewById(R.id.email_input);
        addressIn = findViewById(R.id.address_input);
        phoneIn = findViewById(R.id.phone_input);
        descIn = findViewById(R.id.description_input);
        proBar = findViewById(R.id.pro_bar);
        btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        presenter.bindView(this);
        super.onResume();
    }


    @Override
    public void showProgress() {
        nameIn.setVisibility(View.INVISIBLE);
        emailIn.setVisibility(View.INVISIBLE);
        addressIn.setVisibility(View.INVISIBLE);
        phoneIn.setVisibility(View.INVISIBLE);
        descIn.setVisibility(View.INVISIBLE);
        proBar.setVisibility(View.VISIBLE);
        btnDone.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        nameIn.setVisibility(View.VISIBLE);
        emailIn.setVisibility(View.VISIBLE);
        addressIn.setVisibility(View.VISIBLE);
        phoneIn.setVisibility(View.VISIBLE);
        descIn.setVisibility(View.VISIBLE);
        proBar.setVisibility(View.INVISIBLE);
        btnDone.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        new AlertDialog.Builder(this)
                .setTitle("Error!")
                .setMessage(error)
                .setPositiveButton("Ok", null)
                .create()
                .show();
    }

    @Override
    public void showSuccess(String msg) {
        {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void hideAddContactScreen() {
        presenter.unbindView(this);
        finish();
    }

    @Override
    public void initialise() {

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_done) {
            presenter.onDoneItemSelected(nameIn.getText().toString(),
                    emailIn.getText().toString(),
                    addressIn.getText().toString(),
                    phoneIn.getText().toString(),
                    descIn.getText().toString());

        }
    }

    @Override
    protected void onStop() {
        presenter.unbindView(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.get().clearAddContactComponent();
    }
}
