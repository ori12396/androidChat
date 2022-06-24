package com.example.mychat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mychat.api.ContactsApi;
import com.example.mychat.api.webApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Clist extends AppCompatActivity {
    private AppDB db;
    private ContactsDao contactDao;
    private List<Contact> Contacts;
    private webApi webApi;
    private ContactsApi contactsApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clist);
        final ContactsListAdapter contactsListAdapter=new ContactsListAdapter(this);
        RecyclerView cList=findViewById(R.id.Contacts);
        final ContactsListAdapter listAdapter=new ContactsListAdapter(this);
        cList.setAdapter(listAdapter);
        cList.setLayoutManager(new LinearLayoutManager(this));
        Bundle extras = getIntent().getExtras();
        String currentId=extras.getString("id");

        db= Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB")
                .build();
        contactDao=db.contactsDao();
        List<Contact> l = null;
        FloatingActionButton  btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            Intent intent=new Intent(Clist.this,ContactAdd.class);
            //intent.putExtra("current_username",Id.getText());
            startActivity(intent);
        });
        contactsApi=new ContactsApi();
        webApi=contactsApi.getWebApi();

        //contacts=contactDao.index();
         Call<List<Contact>> call= webApi.getContacts(currentId);
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (response.code()==200){
                    new Thread(()->{
                        contactsListAdapter.setContact(response.body());
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });

    }
}