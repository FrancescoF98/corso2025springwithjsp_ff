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

    // Da ENTITY a DTO - lista
    public List<DocenteDTO> docente_convert_to_dto(List<Docente> elementi_in_entrata){

        // Creo una lista vuota
        List<DocenteDTO> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            //Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();

            DocenteDTO nuovo_elemento = new DocenteDTO(nome, cognome);

            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }

    // Da ENTITY a DTO - singolo elemento
    public DocenteDTO docente_convert_to_dto(Docente elementi_in_entrata){

        DocenteDTO nuovo_elemento = new DocenteDTO(elementi_in_entrata.getNome(), elementi_in_entrata.getCognome());

        return nuovo_elemento;
    }

    // Da DTO a ENTITY - lista
    public List<Docente> docente_convert_to_entity(List<DocenteDTO> elementi_in_entrata){

        // Creo una lista vuota
        List<Docente> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            //Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();

            Docente nuovo_elemento = new Docente();
            nuovo_elemento.setNome(nome);
            nuovo_elemento.setCognome(cognome);

            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }

    // Da DTO a ENTITY - elemento singolo
    public Docente docente_convert_to_entity(DocenteDTO elementi_in_entrata){

        Docente nuovo_elemento = new Docente();

        nuovo_elemento.setNome(elementi_in_entrata.getNome());
        nuovo_elemento.setCognome(elementi_in_entrata.getCognome());

        return nuovo_elemento;
    }

    // --------------------------------------------------------------------------------------------------

    // Da ENTITY a DTO - lista
    public List<DiscenteDTO> discente_convert_to_dto(List<Discente> elementi_in_entrata){

        // Creo una lista vuota
        List<DiscenteDTO> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            //Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();
            Integer matricola = elementi_in_entrata.get(i).getMatricola();
            Integer eta = elementi_in_entrata.get(i).getEta();

            DiscenteDTO nuovo_elemento = new DiscenteDTO(nome, cognome, matricola, eta);

            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }

    // Da ENTITY a DTO - singolo elemento
    public DiscenteDTO discente_convert_to_dto(Discente elementi_in_entrata){

        DiscenteDTO nuovo_elemento = new DiscenteDTO(elementi_in_entrata.getNome(), elementi_in_entrata.getCognome(), elementi_in_entrata.getMatricola(), elementi_in_entrata.getEta());

        return nuovo_elemento;
    }

    // Da DTO a ENTITY - lista
    public List<Discente> discente_convert_to_entity(List<DiscenteDTO> elementi_in_entrata){

        // Creo una lista vuota
        List<Discente> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            //Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();
            Integer matricola = elementi_in_entrata.get(i).getMatricola();
            Integer eta = elementi_in_entrata.get(i).getEta();

            Discente nuovo_elemento = new Discente();
            nuovo_elemento.setNome(nome);
            nuovo_elemento.setCognome(cognome);
            nuovo_elemento.setMatricola(matricola);
            nuovo_elemento.setMatricola(eta);

            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }

    // Da DTO a ENTITY - singolo elemento
    public Discente discente_convert_to_entity(DiscenteDTO elementi_in_entrata){

        Discente nuovo_elemento = new Discente();
        nuovo_elemento.setNome(elementi_in_entrata.getNome());
        nuovo_elemento.setCognome(elementi_in_entrata.getCognome());
        nuovo_elemento.setMatricola(elementi_in_entrata.getMatricola());
        nuovo_elemento.setEta(elementi_in_entrata.getEta());

        return nuovo_elemento;
    }

    // --------------------------------------------------------------------------------------------------

    // Da ENTITY a DTO - lista
    public List<CorsoDTO> corso_convert_to_dto(List<Corso> elementi_in_entrata){

        // Creo una lista vuota
        List<CorsoDTO> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            DocenteDTO id_doc = docente_convert_to_dto(elementi_in_entrata.get(i).getId_doc());
            Integer anno_accademico = elementi_in_entrata.get(i).getAnno_accademico();
            List<DiscenteDTO> discenti = discente_convert_to_dto(elementi_in_entrata.get(i).getDiscenti());

            CorsoDTO nuovo_elemento = new CorsoDTO(id, nome, id_doc, anno_accademico, discenti);

            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }


    // --------------------------------------------------------------------------------------------------
}
