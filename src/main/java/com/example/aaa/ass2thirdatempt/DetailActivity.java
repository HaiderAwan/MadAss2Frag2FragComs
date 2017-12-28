package com.example.aaa.ass2thirdatempt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by aaa on 10/17/2017.
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        Gson gs= new Gson();
        String str = getIntent().getStringExtra("contact");
        ContactDetailEvent contactDetailsEvent = new ContactDetailEvent(str);
        EventBus.getDefault().post(contactDetailsEvent);
        String contact = gs.toJson(str);
    }
}
