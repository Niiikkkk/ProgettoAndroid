package com.ium.example.progetto;

import java.util.Objects;

public class Docente {
    private int idDocente;
    private String nomeDocente;
    private String cognomeDocente;

    public Docente(int idDocente, String nomeDocente, String cognomeDocente) {
        this.idDocente = idDocente;
        this.nomeDocente = nomeDocente;
        this.cognomeDocente = cognomeDocente;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public String getCognomeDocente() {
        return cognomeDocente;
    }

    public void setCognomeDocente(String cognomeDocente) {
        this.cognomeDocente = cognomeDocente;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "idDocente=" + idDocente +
                ", nomeDocente='" + nomeDocente + '\'' +
                ", cognomeDocente='" + cognomeDocente + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return Objects.equals(nomeDocente, docente.nomeDocente) && Objects.equals(cognomeDocente, docente.cognomeDocente);
    }
}
