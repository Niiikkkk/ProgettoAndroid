package com.ium.example.progetto;

import java.io.Serializable;
import java.util.Objects;

public class Utente implements Serializable {
    private int idUtente;
    private String passw;
    private String ruolo;
    private String userId;
    private String nome;
    private String cognome;

    public Utente(int idUtente, String passw, String ruolo, String userId, String nome, String cognome) {
        this.idUtente = idUtente;
        this.passw = passw;
        this.ruolo = ruolo;
        this.userId = userId;
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(userId, utente.userId);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + idUtente +
                ", passw='" + passw + '\'' +
                ", ruolo='" + ruolo + '\'' +
                ", userId='" + userId + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
