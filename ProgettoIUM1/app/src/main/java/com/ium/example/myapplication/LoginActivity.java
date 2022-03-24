package com.ium.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ium.example.progetto.Iteration;
import com.ium.example.progetto.IterationLogin;

public class LoginActivity extends AppCompatActivity {

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
                String url = "servletLogin";
                String data = "logintype=login&loginAccount=" + editTextUsername.getText() + "&password=" + editTextPassword.getText();
                Iteration i = new Iteration();
                i.login(url,data,view,editTextUsername,editTextPassword,txtError);
            }
        });
    }
}