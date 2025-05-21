package com.example.demo.service;

import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Docente;
import com.example.demo.mapper.DocenteMapper;
import com.example.demo.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteService {


    @Autowired
    DocenteRepository docenteRepository;
    @Autowired
    DocenteMapper docenteMapper;


    public List<DocenteDTO> findAll() {
        List<Docente> docenti = docenteRepository.findAll();
        List<DocenteDTO> docentiDTO = new ArrayList<DocenteDTO>();

        for (int i = 0; i < docenti.size(); i++) {
            DocenteDTO nuovo_elemento = docenteMapper.toDto(docenti.get(i));
            docentiDTO.add(nuovo_elemento);
        }

        return docentiDTO;
    }

    public DocenteDTO get(Long id) {
        Docente docente = docenteRepository.findById(id).orElseThrow();
        return docenteMapper.toDto(docente);
    }

    public Docente save(DocenteDTO d) {
        Docente entity = docenteMapper.toEntity(d);
        return docenteRepository.save(entity);
    }

    public void delete(Long id) {
        docenteRepository.deleteById(id);
    }

    // Query custom
    public List<DocenteDTO> ordina_by_nome_asc() {
        List<Docente> docenti = docenteRepository.ordina_by_nome_asc();
        List<DocenteDTO> docentiDTO = new ArrayList<DocenteDTO>();

        for (int i = 0; i < docenti.size(); i++) {
            DocenteDTO nuovo_elemento = docenteMapper.toDto(docenti.get(i));
            docentiDTO.add(nuovo_elemento);
        }

        return docentiDTO;
    }

    public List<DocenteDTO> ordina_by_nome_desc() {
        List<Docente> docenti = docenteRepository.ordina_by_nome_desc();
        List<DocenteDTO> docentiDTO = new ArrayList<DocenteDTO>();

        for (int i = 0; i < docenti.size(); i++) {
            DocenteDTO nuovo_elemento = docenteMapper.toDto(docenti.get(i));
            docentiDTO.add(nuovo_elemento);
        }

        return docentiDTO;
    }

}
