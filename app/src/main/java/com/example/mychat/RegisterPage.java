package com.example.mychat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mychat.api.ContactsApi;
import com.example.mychat.api.webApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity {
    private webApi webApi;
    private ContactsApi contactsApi;

    public boolean checkValid(String toCheck){
        Pattern pattern=Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9])");
        Matcher matcher=pattern.matcher(toCheck);
        return matcher.find();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView goTo=findViewById(R.id.goToLogin);
        Button RegisterBtn=findViewById(R.id.RegisterBtn);
        goTo.setPaintFlags(goTo.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        contactsApi=new ContactsApi();
        webApi=contactsApi.getWebApi();

        goTo.setOnClickListener(v->{
            Intent i=new Intent(this, MainActivity.class);
            startActivity(i);
        });
        RegisterBtn.setOnClickListener(view -> {
            EditText id=findViewById(R.id.id);
            String uId=id.getText().toString();
            EditText pw=findViewById(R.id.pw);
            String upw=pw.getText().toString();
            EditText cpw=findViewById(R.id.cpw);
            String ucpw=cpw.getText().toString();
            EditText display=findViewById(R.id.editTextTextPersonName);
            String udn=display.getText().toString();
            TextView errors=findViewById(R.id.errors);

            if (uId.equals("")||upw.equals("")||ucpw.equals("")||udn.equals("")){
                errors.setText("empty fields!");
                return;
            }
            if (!checkValid(upw)){
                errors.setText("make sure you password contains both num and letters.");
                return;
            }
            if (!upw.equals(ucpw)){
                errors.setText("Please make sure your pw and cpw are the same");
                return;
            }

            Register register=new Register(uId,udn,upw);
            Call<Void> call= webApi.Register(register);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    int x= response.code();
                    if (response.code()==200){
                        Intent intent=new Intent(RegisterPage.this,MainActivity.class);
                        intent.putExtra("current_username",id.getText());
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
            finish();

        });
    }
}