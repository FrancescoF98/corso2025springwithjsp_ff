package com.example.demo.service;

import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.entity.Discente;
import com.example.demo.mapper.DiscenteMapper;
import com.example.demo.repository.DiscenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscenteService {


    @Autowired
    DiscenteRepository discenteRepository;
    @Autowired
    DiscenteMapper discenteMapper;

    public List<DiscenteDTO> findAll() {
        List<Discente> discenti = discenteRepository.findAll();
        List<DiscenteDTO> discentiDTO = new ArrayList<DiscenteDTO>();

        for (int i = 0; i < discenti.size(); i++) {
            DiscenteDTO nuovo_elemento = discenteMapper.toDto(discenti.get(i));
            discentiDTO.add(nuovo_elemento);
        }

        return discentiDTO;
    }

    public DiscenteDTO get(Long id) {
        Discente discente = discenteRepository.findById(id).orElseThrow();
        return discenteMapper.toDto(discente);
    }

    public Discente save(DiscenteDTO s) {
        Discente entity = discenteMapper.toEntity(s);
        return discenteRepository.save(entity);
    }

    public void delete(Long id) {
        discenteRepository.deleteById(id);
    }

    // Query custom
    public List<DiscenteDTO> ordina_by_nome_asc() {
        List<Discente> discenti = discenteRepository.ordina_by_nome_asc();
        List<DiscenteDTO> discentiDTO = new ArrayList<DiscenteDTO>();

        for (int i = 0; i < discenti.size(); i++) {
            DiscenteDTO nuovo_elemento = discenteMapper.toDto(discenti.get(i));
            discentiDTO.add(nuovo_elemento);
        }

        return discentiDTO;
    }

    public List<DiscenteDTO> ordina_by_nome_desc() {
        List<Discente> discenti = discenteRepository.ordina_by_nome_desc();
        List<DiscenteDTO> discentiDTO = new ArrayList<DiscenteDTO>();

        for (int i = 0; i < discenti.size(); i++) {
            DiscenteDTO nuovo_elemento = discenteMapper.toDto(discenti.get(i));
            discentiDTO.add(nuovo_elemento);
        }

        return discentiDTO;
    }

    //
    public List<DiscenteDTO> findAllByIds(List<Long> ids) {
        List<Discente> discenti = discenteRepository.findAllById(ids);
        List<DiscenteDTO> discentiDTO = new ArrayList<DiscenteDTO>();

        for (int i = 0; i < discenti.size(); i++) {
            DiscenteDTO nuovo_elemento = discenteMapper.toDto(discenti.get(i));
            discentiDTO.add(nuovo_elemento);
        }

        return discentiDTO;
    }


}
