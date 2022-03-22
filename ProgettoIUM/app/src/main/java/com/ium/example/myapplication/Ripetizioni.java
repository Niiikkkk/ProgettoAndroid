package com.ium.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ium.example.progetto.Iteration;

public class Ripetizioni extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView myDate;
    private Button checkDate;
    private Iteration i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ripetizioni);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.Date);
        checkDate = (Button) findViewById(R.id.btnDisponibilità);
        i = new Iteration();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                String date = (i1 + 1) + "/" + i2 + "/" + i;
                myDate.setText(date);

            }
        });
    }

    public void checkDate (View view)
    {
       String url = "servletController";
        // funzione che in base al giorno ritorna il json delle lezioni
    }
}
