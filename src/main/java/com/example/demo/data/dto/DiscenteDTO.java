package com.example.demo.data.dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



public class DiscenteDTO {

    private Long id;

    private String nome;

    private String cognome;

    private Integer matricola;

    private Integer eta;


    private List<CorsoDTO> corsi = new ArrayList<>();


    /* costruttori */
    public DiscenteDTO() {}

    public DiscenteDTO(Long id, String nome, String cognome, Integer matricola, Integer eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.eta = eta;
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


    public List<CorsoDTO> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<CorsoDTO> corsi) {
        this.corsi = corsi;
    }

}
