package com.example.mychat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Clist extends AppCompatActivity {
    private AppDB db;
    private ContactsDao contactDao;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clist);
        db= Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB")
                .build();
        contactDao=db.contactsDao();

        FloatingActionButton  btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            // here implementation of adding contact.
        });
        contacts=contactDao.index();
        ListView cList=findViewById(R.id.cList);
        ArrayAdapter<Contact> adapter=new ArrayAdapter<Contact>(this,
                            android.R.layout.simple_expandable_list_item_1,contacts);
        cList.setAdapter(adapter);
    }
}