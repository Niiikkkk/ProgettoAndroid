package com.ium.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ium.example.progetto.Iteration;
import com.ium.example.progetto.Utente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

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
        Login = (Button) findViewById(R.id.submit);
        Username = (EditText) findViewById(R.id.editTextUsername);
        Password = (EditText) findViewById(R.id.editTextPassword);
        Error = (TextView) findViewById(R.id.txtViewError);
        i = new Iteration();
    }

    public void Login (View view)
    {
        String url = "servletLogin";
        String data = "logintype=login&loginAccount=" + Username.getText() + "&password=" + Password.getText();
        i.login(url,data,view,Username,Password,Error);
        }
    }



