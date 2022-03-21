package com.ium.example.myapplication;

import androidx.annotation.NonNull;
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

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient client;
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
        Password =  findViewById(R.id.editTextPassword);
        Error = findViewById(R.id.txtViewError);
        client=new OkHttpClient();
        i = new Iteration();

    }

    public void Login (View v) {
        if (Password.getText() == null || Password.getText().toString().equals("")
                || Username.getText() == null || Username.getText().toString().equals("")) {
            Error.setText("Username and Password required");
            return;
        } else {
            String loginJson = null;
            try {

                loginJson = i.post("servletLogin",
                        "logintype=login&loginAccount=" + Username.getText() + "&password=" + Password.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Gson gson = new Gson();
            Utente u = gson.fromJson(loginJson, Utente.class);
            System.out.println("ciao" + loginJson);
            Intent intent = new Intent(v.getContext(), LoggedActivity.class);
            startActivity(intent);
        }
    }




}