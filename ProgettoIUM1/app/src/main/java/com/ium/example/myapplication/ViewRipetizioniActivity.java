package com.ium.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ium.example.progetto.Ripetizioni;

import java.util.ArrayList;

public class ViewRipetizioniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ripetizioni);
        TextView txtViewLunedi = (TextView) findViewById(R.id.txtViewLunedi);
        TextView txtViewMartedi = (TextView) findViewById(R.id.txtViewMartedi);
        TextView txtViewMercoledi = (TextView) findViewById(R.id.txtViewMercoledi);
        TextView txtViewGiovedi = (TextView) findViewById(R.id.txtViewGiovedi);
        TextView txtViewVenerdi = (TextView) findViewById(R.id.txtViewVenerdi);
        TextView txtViewSabato = (TextView) findViewById(R.id.txtViewSabato);


        String ripetizioni = getIntent().getExtras().getString("ripetizioni");

        ArrayList<Ripetizioni> lunedi = new ArrayList<>();
        ArrayList<Ripetizioni> martedi = new ArrayList<>();
        ArrayList<Ripetizioni> mercoledi = new ArrayList<>();
        ArrayList<Ripetizioni> giovedi = new ArrayList<>();
        ArrayList<Ripetizioni> venerdi = new ArrayList<>();
        ArrayList<Ripetizioni> sabato = new ArrayList<>();

        setRipetizioni(ripetizioni,lunedi,martedi,mercoledi,giovedi,venerdi,sabato);



        txtViewLunedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cliccato lunedi");
                System.out.println(lunedi);
            }
        });

        txtViewMartedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cliccato martedi");
            }
        });

        txtViewMercoledi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cliccato mercoledi");
            }
        });

        txtViewGiovedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cliccato giovedi");
            }
        });

        txtViewVenerdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cliccato venerdi");
            }
        });

        txtViewSabato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cliccato sabato");
            }
        });
    }

    private void setRipetizioni(String ripetizioni, ArrayList<Ripetizioni> lunedi, ArrayList<Ripetizioni> martedi, ArrayList<Ripetizioni> mercoledi, ArrayList<Ripetizioni> giovedi, ArrayList<Ripetizioni> venerdi, ArrayList<Ripetizioni> sabato){
        Gson gson = new Gson();
        Ripetizioni[] reps = (Ripetizioni[]) gson.fromJson(ripetizioni, Ripetizioni[].class);
        for(Ripetizioni r : reps){
            if(r.getDay().equals("Lunedi")){
                lunedi.add(r);
            }
            if(r.getDay().equals("Martedi")){
                martedi.add(r);
            }
            if(r.getDay().equals("Mercoledi")){
                mercoledi.add(r);
            }
            if(r.getDay().equals("Giovedi")){
                giovedi.add(r);
            }
            if(r.getDay().equals("Venerdi")){
                venerdi.add(r);
            }
            if(r.getDay().equals("Sabato")){
                sabato.add(r);
            }
        }
    }
}