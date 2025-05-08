package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


// utilizzare model_and_view al posto di model

@Entity
@Table(name = "discenti")
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private Integer matricola;

    @Column(nullable = false)
    private Integer eta;

    @Column(nullable = false)
    private String citta_residenza;

    /*
    @ManyToMany(mappedBy = "corso_discente")
    private List<Corso> corsi = new ArrayList<>();
     */

    /* costruttori */
    public Discente() {}

    public Discente(String nome, String cognome, Integer matricola, Integer eta, String citta_residenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.eta = eta;
        this.citta_residenza = citta_residenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getCitta_residenza() {
        return citta_residenza;
    }

    public void setCitta_residenza(String citta_residenza) {
        this.citta_residenza = citta_residenza;
    }

    /*
    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }
     */
}
