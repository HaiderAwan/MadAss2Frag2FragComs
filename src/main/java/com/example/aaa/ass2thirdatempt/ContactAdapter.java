package com.example.aaa.ass2thirdatempt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by aaa on 10/17/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    private static final String TAG = "MTAG";
    private List<Contact> contactList;
    Context context;

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, number, email;
        public Button remove;
        public ImageView prfl_image;
        public RelativeLayout item;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            number = (TextView) view.findViewById(R.id.number);
            prfl_image = (ImageView) view.findViewById(R.id.prfl_image);
            remove = (Button) view.findViewById(R.id.remove);
            item = (RelativeLayout) view.findViewById(R.id.item);
            email = (TextView) view.findViewById(R.id.email);
        }
    }

    public ContactAdapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.MyViewHolder holder, final int position) {
        final Contact contact = contactList.get(position);
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());
        holder.email.setText(contact.getEmail());
        Picasso.with(context)
                .load("www.abbieterpening.com/wp-content/uploads/2013/profile-pic-round-200px.png")
                .resize(160, 160)
                .centerCrop()
                .into(holder.prfl_image);
        holder.item.setOnClickListener(new View.OnClickListener() {
            Intent callIntent;
            Gson gson;
            String str;
            Contact contact;

            @Override
            public void onClick(View v) {
                contact = contactList.get(position);
                gson = new Gson();
                str = gson.toJson(contact);
                callIntent = new Intent(context, DetailActivity.class);
                callIntent.putExtra("Contact", str);
                context.startActivity(callIntent);
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact Name = contactList.get(position);
                contactList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, contactList.size());
                Toast.makeText(context, " Selected Item is Removed " + Name, Toast.LENGTH_SHORT).show();

                // Log.d(TAG, "Contact JSON is  " + str);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size()  ;
    }
}
