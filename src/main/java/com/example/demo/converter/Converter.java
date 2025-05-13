package com.example.demo.converter;

import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    // DOCENTE
    public List<DocenteDTO> docente_convert_to_dto(List<Docente> elementi_in_entrata){

        List<DocenteDTO> elementi_convertiti = new ArrayList<>();

        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();

            DocenteDTO nuovo_elemento = new DocenteDTO(nome, cognome);

            elementi_convertiti.add(nuovo_elemento);
        }

        return elementi_convertiti;
    }


    // DISCENTE
    public List<DiscenteDTO> discente_convert_to_dto(List<Discente> elementi_in_entrata){

        List<DiscenteDTO> elementi_convertiti = new ArrayList<>();

        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();
            Integer matricola = elementi_in_entrata.get(i).getMatricola();
            Integer eta = elementi_in_entrata.get(i).getEta();

            DiscenteDTO nuovo_elemento = new DiscenteDTO(nome, cognome, matricola, eta);

            elementi_convertiti.add(nuovo_elemento);
        }

        return elementi_convertiti;
    }

}
