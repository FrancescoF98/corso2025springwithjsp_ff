package com.example.demo.service;

import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.mapper.CorsoMapper;
import com.example.demo.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorsoService {


    @Autowired
    CorsoRepository corsoRepository;
    @Autowired
    CorsoMapper corsoMapper;

    public List<CorsoDTO> findAll() {
        List<Corso> corsi = corsoRepository.findAll();
        List<CorsoDTO> corsiDTO = new ArrayList<CorsoDTO>();

        for (int i = 0; i < corsi.size(); i++) {
            CorsoDTO nuovo_elemento = corsoMapper.toDto(corsi.get(i));
            corsiDTO.add(nuovo_elemento);
        }

        return corsiDTO;
    }

    public CorsoDTO get(Long id) {
        Corso corso = corsoRepository.findById(id).orElseThrow();
        return corsoMapper.toDto(corso);
    }

    public Corso save(CorsoDTO s) {
        Corso entity = corsoMapper.toEntity(s);
        return corsoRepository.save(entity);
    }

    public void delete(Long id) {
        corsoRepository.deleteById(id);
    }

    // Query custom
    public List<CorsoDTO> ordina_by_nome_asc() {
        List<Corso> corsi = corsoRepository.ordina_by_nome_asc();
        List<CorsoDTO> corsiDTO = new ArrayList<CorsoDTO>();

        for (int i = 0; i < corsi.size(); i++) {
            CorsoDTO nuovo_elemento = corsoMapper.toDto(corsi.get(i));
            corsiDTO.add(nuovo_elemento);
        }

        return corsiDTO;
    }

    public List<CorsoDTO> ordina_by_nome_desc() {
        List<Corso> corsi = corsoRepository.ordina_by_nome_desc();
        List<CorsoDTO> corsiDTO = new ArrayList<CorsoDTO>();

        for (int i = 0; i < corsi.size(); i++) {
            CorsoDTO nuovo_elemento = corsoMapper.toDto(corsi.get(i));
            corsiDTO.add(nuovo_elemento);
        }

        return corsiDTO;
    }
}

