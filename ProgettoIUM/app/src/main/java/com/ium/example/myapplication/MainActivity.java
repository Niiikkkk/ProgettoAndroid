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

import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {

    private Button Login;
    private EditText Username;
    private EditText Password;
    private TextView Error;
    private Iteration i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login = findViewById(R.id.submit);
        Username = findViewById(R.id.editTextUsername);
        Password = findViewById(R.id.editTextPassword);
        Error = findViewById(R.id.txtViewError);
        i = new Iteration();
    }

    public void Login (View view)
    {
        if(Password.getText()==null || Password.getText().toString().equals("")
                || Username.getText()==null || Username.getText().toString().equals("")){
            Error.setText("Username and Password required");
            return;
        }else {
            new Thread(){
                @Override
                public void run() {
                    String loginJson = i.login("servletLogin", "logintype=login&loginAccount=" + Username.getText() + "&password=" + Password.getText());
                    System.out.println(loginJson);
                    Gson gson = new Gson();
                    Utente u = gson.fromJson(loginJson, Utente.class);
                    System.out.println(u);
                    Intent intent = new Intent(view.getContext(), LoggedActivity.class);
                    startActivity(intent);

               }
            }.start();
        }
    }
}