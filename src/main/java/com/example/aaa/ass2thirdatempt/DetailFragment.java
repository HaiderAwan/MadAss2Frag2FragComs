package com.example.aaa.ass2thirdatempt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    EventBus myEventBus;
    View rootView;
    Gson gson;
    TextView name;
    TextView number;
    TextView email;
    public DetailFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        gson = new Gson();
        EventBus.getDefault().register(this);
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        name = (TextView) view.findViewById(R.id.name);
        email = (TextView) view.findViewById(R.id.email);
        number = (TextView) view.findViewById(R.id.number);

        return view;

    }

    public void onEvent(com.example.aaa.ass2thirdatempt.ContactDetailEvent event) {
        String str = event.getMessage();
        Contact contact = gson.fromJson(str, Contact.class);
        name.setText(contact.getName().toString());
        email.setText(contact.getEmail().toString());
        number.setText(contact.getNumber().toString());

    }

}
