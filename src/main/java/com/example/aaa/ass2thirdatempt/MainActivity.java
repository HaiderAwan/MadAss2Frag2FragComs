package com.example.aaa.ass2thirdatempt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
        private List<Contact> contactList = new ArrayList<>();
        private RecyclerView recyclerView;
        private ContactAdapter adapter;
        private ImageView image;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            adapter = new ContactAdapter(contactList,this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(adapter);

            prepareContactData();
        }

        private void prepareContactData() {

            for (int i = 0; i < 1000; i++) {
                contactList.add(new Contact("Name    " + i, "Number" + i, "Remove ", "Gmail " + i + "@ gmail.com"));
            }
            adapter.notifyDataSetChanged();
        }
    }

