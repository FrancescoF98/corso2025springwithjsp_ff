package com.example.demo.data.dto;

import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CorsoDTO {

    private Long id;

    private String nome;

    private Docente id_doc;

    private Integer anno_accademico;

    private List<Discente> discenti = new ArrayList<>();


    /* costruttori */
    public CorsoDTO() {}

    public CorsoDTO(Long id, String nome, Docente id_doc, Integer anno_accademico, List<Discente> discenti) {
        this.id = id;
        this.nome = nome;
        this.id_doc = id_doc;
        this.anno_accademico = anno_accademico;
        this.discenti = discenti;
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

    public Docente getId_doc() {
        return id_doc;
    }

    public void setId_doc(Docente id_doc) {
        this.id_doc = id_doc;
    }

    public Integer getAnno_accademico() {
        return anno_accademico;
    }

    public void setAnno_accademico(Integer anno_accademico) {
        this.anno_accademico = anno_accademico;
    }

    //
    public List<Discente> getDiscenti() {
        return discenti;
    }

    public void setDiscenti(List<Discente> discenti) {
        this.discenti = discenti;
    }

}

