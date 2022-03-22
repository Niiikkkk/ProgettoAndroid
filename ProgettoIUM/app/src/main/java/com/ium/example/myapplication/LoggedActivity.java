package com.ium.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ium.example.progetto.Iteration;

public class LoggedActivity extends AppCompatActivity {

    private Button Ripetizioni;
    private Button MyRipetizioni;
    private Button Logout;
    private TextView txtLogged;
    private Iteration i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        Ripetizioni = findViewById(R.id.btnRipetizioni);
        MyRipetizioni = findViewById(R.id.btnMyRipetizioni);
        Logout = findViewById(R.id.btnLogout);
        txtLogged = findViewById(R.id.txtViewLogged);
        i = new Iteration();
    }


    public void VisualizzaRipetizioni(View view)
    {
        Intent intent = new Intent(view.getContext(), Ripetizioni.class);
        startActivity(intent);
    }

    public void VisualizzaMyRipetizioni(View view)
    {

    }

    public void Logout(View view)
    {

    }
}