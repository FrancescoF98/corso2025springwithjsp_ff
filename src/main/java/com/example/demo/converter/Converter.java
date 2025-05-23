package com.example.demo.converter;

import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    // DOCENTE
    public List<DocenteDTO> docente_convert_to_dto(List<Docente> elementi_in_entrata){

        // Creo una lista vuota
        List<DocenteDTO> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();

            DocenteDTO nuovo_elemento = new DocenteDTO(id, nome, cognome);

            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }


    // DISCENTE
    public List<DiscenteDTO> discente_convert_to_dto(List<Discente> elementi_in_entrata){

        // Creo una lista vuota
        List<DiscenteDTO> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();
            Integer matricola = elementi_in_entrata.get(i).getMatricola();
            Integer eta = elementi_in_entrata.get(i).getEta();

            DiscenteDTO nuovo_elemento = new DiscenteDTO(id, nome, cognome, matricola, eta);

            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }

//    // CORSO
//    public List<CorsoDTO> discente_convert_to_dto(List<Corso> elementi_in_entrata){
//
//        // Creo una lista vuota
//        List<CorsoDTO> elementi_convertiti = new ArrayList<>();
//
//        // la riempio di elementi convertiti
//        for (int i = 0; i < elementi_in_entrata.size(); i++) {
//
//            Long id = elementi_in_entrata.get(i).getId();
//            String nome = elementi_in_entrata.get(i).getNome();
//            Docente id_doc = elementi_in_entrata.get(i).getId_doc();
//            Integer anno_accademico = elementi_in_entrata.get(i).getAnno_accademico();
//            List<Discente> discenti = elementi_in_entrata.get(i).getDiscenti();
//
//            DiscenteDTO nuovo_elemento = new DiscenteDTO(id, nome, id_doc, anno_accademico, discenti);
//
//            elementi_convertiti.add(nuovo_elemento);
//        }
//
//        // restituisco la lista convertita
//        return elementi_convertiti;
//    }

}
