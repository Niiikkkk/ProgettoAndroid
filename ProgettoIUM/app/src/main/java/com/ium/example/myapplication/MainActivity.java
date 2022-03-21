package com.ium.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ium.example.progetto.Iteration;
import com.ium.example.progetto.Utente;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.submit);
        EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        TextView txtError = (TextView) findViewById(R.id.txtViewError);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextPassword.getText()==null || editTextPassword.getText().toString().equals("")
                        || editTextUsername.getText()==null || editTextUsername.getText().toString().equals("")){
                    txtError.setText("Username and Password required");
                    return;
                }else {
                    new Thread(){
                        @Override
                        public void run() {
                            Iteration i = new Iteration();
                            String loginJson = i.login("servletLogin", "logintype=login&loginAccount=" + editTextUsername.getText() + "&password=" + editTextPassword.getText());
                            System.out.println(loginJson);
                            Gson gson = new Gson();
                            Utente u = gson.fromJson(loginJson, Utente.class);
                            System.out.println(u);
                            Intent intent = new Intent(this, LoggedActivity.class);
                            startActivity(intent);

                        }
                    }.start();
                }
            }
        });
    }
}