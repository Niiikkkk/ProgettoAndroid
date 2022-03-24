package com.ium.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ium.example.progetto.Iteration;
import com.ium.example.progetto.Utente;

public class LoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        TextView txtViewLogged = (TextView) findViewById(R.id.txtViewLogged);
        Button btnVisualizzaRipetizioni = (Button) findViewById(R.id.btnVisualizzaRipetizioni);
        Button btnVisualizzaTutte = (Button) findViewById(R.id.btnVisualizzaTutte);
        Button btnLogout = (Button) findViewById(R.id.btnLogout);

        Bundle b = getIntent().getExtras();
        Utente u = (Utente) b.getSerializable("user");
        String cookie = b.getString("cookie");

        if(u != null){
            txtViewLogged.setText("Logged as " + u.getNome() + " " + u.getCognome() + " as " + u.getRuolo());
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "servletLogin";
                String data = "logintype=logout";
                Iteration i = new Iteration();
                i.logout(url,data);
                finish();
            }
        });

        btnVisualizzaRipetizioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "servletController";
                String data = "typeRequest=visRip";
                Iteration i = new Iteration();
                i.visRip(view,url,data,cookie);
            }
        });

        btnVisualizzaTutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "servletController";
                String data = "typeRequest=visPre&print=mine";
                Iteration i = new Iteration();
                i.visPre(view,url,data,cookie);
            }
        });
    }
}