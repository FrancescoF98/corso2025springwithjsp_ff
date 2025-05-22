package com.example.demo.data.dto;

import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CorsoDTO {

    @JsonIgnore
    private Long id;

    private String nome;

    private DocenteDTO id_doc;

    private Integer anno_accademico;

    private List<DiscenteDTO> discenti = new ArrayList<>();


    /* costruttori */
    public CorsoDTO() {}

    public CorsoDTO(Long id, String nome, DocenteDTO id_doc, Integer anno_accademico, List<DiscenteDTO> discenti) {
        this.id = id;
        this.nome = nome;
        this.id_doc = id_doc;
        this.anno_accademico = anno_accademico;
        this.discenti = discenti;
    }

    @JsonIgnore
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

    public DocenteDTO getId_doc() {
        return id_doc;
    }

    public void setId_doc(DocenteDTO id_doc) {
        this.id_doc = id_doc;
    }

    public Integer getAnno_accademico() {
        return anno_accademico;
    }

    public void setAnno_accademico(Integer anno_accademico) {
        this.anno_accademico = anno_accademico;
    }

    //
    public List<DiscenteDTO> getDiscenti() {
        return discenti;
    }

    public void setDiscenti(List<DiscenteDTO> discenti) {
        this.discenti = discenti;
    }

}

