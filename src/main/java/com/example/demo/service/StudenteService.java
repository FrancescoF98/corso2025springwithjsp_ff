package com.example.demo.service;

import com.example.demo.entity.Studente;
import com.example.demo.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {


    @Autowired
    StudenteRepository studenteRepository;

    public List<Studente> findAll() {
        return studenteRepository.findAll();
    }

    public Studente get(Long id) {
        return studenteRepository.findById(id).orElseThrow();
    }

    public Studente save(Studente s) {
        return studenteRepository.save(s);
    }

    public void delete(Long id) {
        studenteRepository.deleteById(id);
    }

    // Query custom
    public List<Studente> ordina_by_nome_asc() {
        return studenteRepository.ordina_by_nome_asc();
    }

    public List<Studente> ordina_by_nome_desc() {
        return studenteRepository.ordina_by_nome_desc();
    }
}
