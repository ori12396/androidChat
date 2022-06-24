package com.example.mychat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mychat.api.ContactsApi;
import com.example.mychat.api.webApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private com.example.mychat.api.webApi webApi;
    private ContactsApi contactsApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView goTo=(TextView) findViewById(R.id.goToRegister);
        goTo.setPaintFlags(goTo.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Button btnLogin=findViewById(R.id.btnLogin);
        EditText id=findViewById(R.id.id);
        EditText pw=findViewById(R.id.pw);
        TextView textView=findViewById(R.id.textView);
        contactsApi=new ContactsApi();
        webApi=contactsApi.getWebApi();
        btnLogin.setOnClickListener(view -> {
            String uid=id.getText().toString();
            String upw=pw.getText().toString();
            if (upw.isEmpty()||uid.isEmpty()){
                textView.setText("empty fields");
                return;
            }
            Login login=new Login(uid,upw);
            Call<Void> call=webApi.Login(login);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code()==200){
                        Intent intent=new Intent(MainActivity.this,Clist.class);
                        textView.setText("goooooooodddddd");
                        intent.putExtra("id",uid);
                        startActivity(intent);
                    }else {
                        textView.setText("Wrong id or pw");
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
            textView.setText("");
            finish();
        });
        goTo.setOnClickListener(v->{
            Intent i=new Intent(this, RegisterPage.class);
            startActivity(i);
        });
    }
}