package it.be.codingRace.entity;

import lombok.Getter;
import lombok.Setter;

public class Utente {


    @Getter@Setter
    private String nome;
    @Getter@Setter
    private String cognome;
    @Getter@Setter
    private String username;
    @Getter@Setter
    private String password;


    public Utente(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }
}
