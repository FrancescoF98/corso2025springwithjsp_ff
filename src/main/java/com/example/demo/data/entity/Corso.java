package com.example.demo.data.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "corsi")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
//    @JoinColumn(name = "id_doc", nullable = false)
    @JoinColumn(name = "id_doc")
    private Docente id_doc;

    @Column(nullable = false)
    private Integer anno_accademico;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "corso_discente",
            joinColumns = @JoinColumn(name = "id_corso"),
            inverseJoinColumns = @JoinColumn(name = "id_discente")
    )
    private List<Discente> discenti = new ArrayList<>();


    /* costruttori */
    public Corso() {}

    public Corso(String nome, Docente id_doc, Integer anno_accademico) {
        this.nome = nome;
        this.id_doc = id_doc;
        this.anno_accademico = anno_accademico;
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

