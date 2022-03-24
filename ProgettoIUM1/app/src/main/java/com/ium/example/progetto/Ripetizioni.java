package com.ium.example.progetto;

import java.util.ArrayList;
import java.util.Objects;

public class Ripetizioni {
    private Corso corso;
    private Docente docente;
    private Utente utente;
    private String day;
    private String hour;
    private String status;


    public Ripetizioni(Corso corso, Docente docente, Utente utente, String day, String hour, String status) {
        this.corso = corso;
        this.docente = docente;
        this.utente = utente;
        this.day = day;
        this.hour = hour;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ripetizioni that = (Ripetizioni) o;
        if(utente != null) {
            return Objects.equals(utente, that.utente) && Objects.equals(hour, that.hour) && Objects.equals(day,that.day) && status.equals(that.status);
        }else{
            return docente == that.docente && Objects.equals(day, that.day) && Objects.equals(hour, that.hour) && status.equals(that.status);
        }
    }

    @Override
    public String toString() {
        return "Ripetizioni{" +
                "corso='" + corso + '\'' +
                ", docente=" + docente +
                ", utente=" + utente +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}