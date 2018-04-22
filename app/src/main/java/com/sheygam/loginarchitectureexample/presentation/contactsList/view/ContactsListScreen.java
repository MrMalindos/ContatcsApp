package com.sheygam.loginarchitectureexample.presentation.contactsList.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.sheygam.loginarchitectureexample.R;
import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.presentation.addContact.view.AddContactActivity;
import com.sheygam.loginarchitectureexample.presentation.contactdescription.view.ContactDescriptionActivity;
import com.sheygam.loginarchitectureexample.presentation.contactsList.adapters.MyAdapter;
import com.sheygam.loginarchitectureexample.presentation.contactsList.presenter.ContactsListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContactsListScreen extends MvpAppCompatActivity implements IContactsListView {

    @InjectPresenter
    ContactsListPresenter presenter;

    @BindView(R.id.contacts_progress_bar)
    ProgressBar contactsProgressBar;
    @BindView(R.id.my_recycler_view)
    RecyclerView contactsList;
    @BindView(R.id.empty_list_txt)
    TextView emptyList;
    @BindView(R.id.toolbar_actionbar)
    Toolbar toolbar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        presenter.initialize();
        super.onResume();
    }

    @Override
    public void hideContactsListScreen() {
        finish();
    }

    @Override
    public void showProgress() {
        contactsProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        contactsProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(error)
                .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss())
                .setCancelable(false)
                .create();
        dialog.show();
    }

    @Override
    public void showEmptyList() {
        emptyList.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContactsList(List<Contact> list) {
        contactsList.setLayoutManager(new LinearLayoutManager(this));
        contactsList.setAdapter(new MyAdapter(list, presenter));
        contactsList.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContactDescriptionScreen(Contact contact) {
        startActivity(ContactDescriptionActivity.newIntent(this, contact));
    }

    @Override
    public void showAddNewContactScreen() {
        startActivity(new Intent(this, AddContactActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout_item) {
            presenter.onLogOutItemSelected();
        } else if (item.getItemId() == R.id.add_item) {
            presenter.onAddContactButtonClicked();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
