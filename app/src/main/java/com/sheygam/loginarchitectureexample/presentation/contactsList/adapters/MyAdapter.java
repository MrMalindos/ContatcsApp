package com.sheygam.loginarchitectureexample.presentation.contactsList.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sheygam.loginarchitectureexample.R;
import com.sheygam.loginarchitectureexample.data.dao.Contact;
import com.sheygam.loginarchitectureexample.presentation.contactsList.presenter.IContactsListPresenter;

import java.util.List;

/**
 * Created by Gleb on 27.01.2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Contact> contacts;
    private IContactsListPresenter presenter;

    public MyAdapter(List<Contact> contacts, IContactsListPresenter presenter) {
        this.contacts = contacts;
        this.presenter = presenter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact currentContact = contacts.get(position);
        holder.nameTxt.setText(currentContact.getFullName());
        holder.emailTxt.setText(currentContact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTxt, emailTxt;

        MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameTxt = itemView.findViewById(R.id.name_txt);
            emailTxt = itemView.findViewById(R.id.email_txt);
        }

        @Override
        public void onClick(View v) {
            presenter.onContactItemSelected(contacts.get(getAdapterPosition()));
        }
    }
}
