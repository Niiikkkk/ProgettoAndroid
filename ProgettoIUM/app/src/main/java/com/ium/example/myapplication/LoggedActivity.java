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

    private Button Ripetizioni;
    private Button MyRipetizioni;
    private Button Logout;
    private TextView txtLogged;
    private Iteration i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        Ripetizioni = (Button) findViewById(R.id.btnRipetizioni);
        MyRipetizioni = (Button) findViewById(R.id.btnMyRipetizioni);
        Logout = (Button) findViewById(R.id.btnLogout);
        txtLogged = (TextView) findViewById(R.id.txtViewLogged);
        i = new Iteration();
        Bundle b = getIntent().getExtras();
        Utente u = (Utente) b.getSerializable("user");
        if(u != null){
            txtLogged.setText("Logged as " + u.getNome() + " " + u.getCognome() + " as " + u.getRuolo());
        }
    }


    public void VisualizzaRipetizioni(View view)
    {
        Intent intent = new Intent(view.getContext(), Ripetizioni.class);
        startActivity(intent);
    }

    public void VisualizzaMyRipetizioni(View view)
    {
        String url = "servletController";
        String data = "??";    // vedere funzioni su intellij
        i.MyRipetizioni(url);

    }

    public void Logout(View view)
    {
        String url = "servletLogin";
        String data = "logintype=logout";
        i.logout(url,data);
        finish();
    }
}