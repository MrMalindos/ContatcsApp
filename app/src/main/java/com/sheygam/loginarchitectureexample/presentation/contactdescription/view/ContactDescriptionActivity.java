package com.sheygam.loginarchitectureexample.presentation.contactdescription.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sheygam.loginarchitectureexample.App;
import com.sheygam.loginarchitectureexample.R;
import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.di.contactdescription.ContactDescriptionModule;
import com.sheygam.loginarchitectureexample.presentation.contactdescription.presenter.IContactDescriptionPresenter;
import com.sheygam.loginarchitectureexample.presentation.login.presenter.ILoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactDescriptionActivity extends AppCompatActivity implements IContactDescriptionView{

    @BindView(R.id.contact_description_toolbar) Toolbar toolbar;
    @BindView(R.id.contact_description_edit_btn) FloatingActionButton editContactButton;
    @BindView(R.id.contact_description_name_txt) TextView nameTxt;
    @BindView(R.id.contact_description_phone_txt) TextView phoneTxt;
    @BindView(R.id.contact_description_email_txt) TextView emailTxt;
    @BindView(R.id.contact_description_description_txt) TextView descTxt;
    @BindView(R.id.contact_description_address_txt) TextView addressTxt;
    @BindView(R.id.loading_layout)FrameLayout loadingLayout;
    @BindView(R.id.contact_description_coordinator_layout) CoordinatorLayout coordinatorLayout;

    @Inject
    IContactDescriptionPresenter mContactDescriptionPresenter;

    public static final String EXTRA_CONTACT = "extraContact";

    public static Intent newIntent(Context context, Contact contact){
        Intent intent = new Intent(context, ContactDescriptionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_CONTACT, contact);
        intent.putExtras(bundle);
        return intent;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_description);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        App.get().plusContactDescriptionModule(new ContactDescriptionModule()).inject(this);
        Intent intent = getIntent();

        mContactDescriptionPresenter.bindView(this);
        mContactDescriptionPresenter.initialize((Contact) intent.getSerializableExtra(EXTRA_CONTACT));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_description_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.contact_description_menu_delete_item){
            mContactDescriptionPresenter.onDeleteItemSelected();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContactDescriptionPresenter.unbindView();
        App.get().clearContactDescriptionComponent();
    }

    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void showRemoveContactError(String error) {
        Snackbar.make(coordinatorLayout, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideContactDescriptionScreen() {
        finish();
    }

    @Override
    public void setActionBarTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void setContactFullName(String name) {
        nameTxt.setText(name);
    }

    @Override
    public void setContactEmail(String email) {
        emailTxt.setText(email);
    }

    @Override
    public void setContactPhoneNumber(String phoneNumber) {
        phoneTxt.setText(phoneNumber);
    }

    @Override
    public void setContactAddress(String address) {
        addressTxt.setText(address);
    }

    @Override
    public void setContactDescription(String desc) {
        descTxt.setText(desc);
    }
}
