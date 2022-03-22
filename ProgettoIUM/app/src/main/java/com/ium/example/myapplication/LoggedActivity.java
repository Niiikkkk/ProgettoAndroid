package com.ium.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        if(u != null){
            txtViewLogged.setText("Logged as " + u.getNome() + " " + u.getCognome() + " as " + u.getRuolo());
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}