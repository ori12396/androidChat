package com.example.mychat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ContactAdd extends AppCompatActivity {
    private AppDB db;
    private ContactsDao contactDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);
        Button  cBtnAdd=findViewById(R.id.cBtnAdd);
        cBtnAdd.setOnClickListener(view -> {
            EditText fId=findViewById(R.id.fId);
            EditText fDn=findViewById(R.id.fDn);
            EditText fS=findViewById(R.id.fS);
            Contact contact=new Contact(fId.getText().toString(),fDn.getText().toString(),
                    fS.getText().toString());
            //here request for the server to check if this contact is exist and add him with
            // contactAdo.insert(contact)
        });
    }
}