package com.example.demo.converter;

import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import com.example.demo.repository.DiscenteRepository;
import com.example.demo.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Converter {

    @Autowired
    DocenteRepository docenteRepository;
    @Autowired
    DiscenteRepository discenteRepository;

    // Da ENTITY a DTO - lista
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

    // Da ENTITY a DTO - singolo elemento
    public DocenteDTO docente_convert_to_dto(Docente elementi_in_entrata){

        DocenteDTO nuovo_elemento = new DocenteDTO(elementi_in_entrata.getId(), elementi_in_entrata.getNome(), elementi_in_entrata.getCognome());

        return nuovo_elemento;
    }

    // Da DTO a ENTITY - lista
    public List<Docente> docente_convert_to_entity(List<DocenteDTO> elementi_in_entrata){

        // Creo una lista vuota
        List<Docente> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();

            Docente nuovo_elemento = new Docente();
            nuovo_elemento.setId(id);
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

        nuovo_elemento.setId(elementi_in_entrata.getId());
        nuovo_elemento.setNome(elementi_in_entrata.getNome());
        nuovo_elemento.setCognome(elementi_in_entrata.getCognome());

        return nuovo_elemento;
    }

    // --------------------------------------------------------------------------------------------------
    private void a________________________________(){}
    // --------------------------------------------------------------------------------------------------

    // Da ENTITY a DTO - lista
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

    // Da ENTITY a DTO - singolo elemento
    public DiscenteDTO discente_convert_to_dto(Discente elementi_in_entrata){

        DiscenteDTO nuovo_elemento = new DiscenteDTO(elementi_in_entrata.getId(), elementi_in_entrata.getNome(), elementi_in_entrata.getCognome(), elementi_in_entrata.getMatricola(), elementi_in_entrata.getEta());

        return nuovo_elemento;
    }

    // Da DTO a ENTITY - lista
    public List<Discente> discente_convert_to_entity(List<DiscenteDTO> elementi_in_entrata){

        // Creo una lista vuota
        List<Discente> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            String cognome = elementi_in_entrata.get(i).getCognome();
            Integer matricola = elementi_in_entrata.get(i).getMatricola();
            Integer eta = elementi_in_entrata.get(i).getEta();

            Discente nuovo_elemento = new Discente();
            nuovo_elemento.setId(id);
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
        nuovo_elemento.setId(elementi_in_entrata.getId());
        nuovo_elemento.setNome(elementi_in_entrata.getNome());
        nuovo_elemento.setCognome(elementi_in_entrata.getCognome());
        nuovo_elemento.setMatricola(elementi_in_entrata.getMatricola());
        nuovo_elemento.setEta(elementi_in_entrata.getEta());

        return nuovo_elemento;
    }

    // --------------------------------------------------------------------------------------------------
    private void b________________________________(){}
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

    // Da ENTITY a DTO - singolo elemento
    public CorsoDTO corso_convert_to_dto(Corso elementi_in_entrata){

        CorsoDTO nuovo_elemento = new CorsoDTO();

        nuovo_elemento.setId(elementi_in_entrata.getId());
        nuovo_elemento.setNome(elementi_in_entrata.getNome());
        nuovo_elemento.setId_doc(docente_convert_to_dto(elementi_in_entrata.getId_doc()));


        return nuovo_elemento;
    }

    // Da DTO a ENTITY - lista
    public List<Corso> corso_convert_to_entity(List<CorsoDTO> elementi_in_entrata){

        // Creo una lista vuota
        List<Corso> elementi_convertiti = new ArrayList<>();

        // la riempio di elementi convertiti
        for (int i = 0; i < elementi_in_entrata.size(); i++) {

            Long id = elementi_in_entrata.get(i).getId();
            String nome = elementi_in_entrata.get(i).getNome();
            Integer anno_accademico = elementi_in_entrata.get(i).getAnno_accademico();
            //List<Discente> discenti = discente_convert_to_entity(elementi_in_entrata.get(i).getDiscenti());

            Corso nuovo_elemento = new Corso();
            nuovo_elemento.setId(id);
            nuovo_elemento.setNome(nome);
            nuovo_elemento.setAnno_accademico(anno_accademico);
            //nuovo_elemento.setDiscenti(discenti);


            // Per assegnare il Docente a partire da un DocenteDTO
            ///  prendo l'id
            Long id_docente = elementi_in_entrata.get(i).getId_doc().getId();
            ///  cerco il docente
            Docente docente_da_collegare = docenteRepository.findById(id_docente)
                    .orElseThrow(() -> new RuntimeException("Docente with ID " + id_docente + " not found"));;
            ///  assegno il docente
            nuovo_elemento.setId_doc(docente_da_collegare);


            /// --- Per assegnare i Discenti a partire da una lista di DiscentiDTO
            // Creo una lista vuota
            List<Discente> discenti_collegati = new ArrayList<>();

            // la riempio di discenti presi dal DB
            for (int j = 0; j < elementi_in_entrata.get(i).getDiscenti().size(); i++) {

                Long id_discente = elementi_in_entrata.get(i).getDiscenti().get(j).getId();
                Discente discente_da_collegare = discenteRepository.findById(id_discente)
                        .orElseThrow(() -> new RuntimeException("Discente with ID " + id_discente + " not found"));
                discenti_collegati.add(discente_da_collegare);
            }

            // assegno la lista
            nuovo_elemento.setDiscenti(discenti_collegati);


            elementi_convertiti.add(nuovo_elemento);
        }

        // restituisco la lista convertita
        return elementi_convertiti;
    }

    // Da DTO a ENTITY - singolo elemento
    public Corso corso_convert_to_entity(CorsoDTO elementi_in_entrata){

        Long id = elementi_in_entrata.getId();
        String nome = elementi_in_entrata.getNome();
        Docente id_doc = docente_convert_to_entity(elementi_in_entrata.getId_doc());
        Integer anno_accademico = elementi_in_entrata.getAnno_accademico();
        //List<Discente> discenti = discente_convert_to_entity(elementi_in_entrata.getDiscenti());

        Corso nuovo_elemento = new Corso();

        nuovo_elemento.setNome(nome);
        nuovo_elemento.setId_doc(id_doc);
        nuovo_elemento.setAnno_accademico(anno_accademico);

        /// --- Per assegnare il Docente a partire da un DocenteDTO
        //  prendo l'id
        Long id_docente = elementi_in_entrata.getId_doc().getId();
        //  cerco il docente nel DB
        Docente docente_da_collegare = docenteRepository.findById(id_docente)
                .orElseThrow(() -> new RuntimeException("Docente with ID " + id_docente + " not found"));;
        //  assegno il docente
        nuovo_elemento.setId_doc(docente_da_collegare);


        /// --- Per assegnare i Discenti a partire da una lista di DiscentiDTO
        // Creo una lista vuota
        List<Discente> discenti_collegati = new ArrayList<>();

        // la riempio di discenti presi dal DB
        for (int i = 0; i < elementi_in_entrata.getDiscenti().size(); i++) {

            Long id_discente = elementi_in_entrata.getDiscenti().get(i).getId();
            Discente discente_da_collegare = discenteRepository.findById(id_discente)
                    .orElseThrow(() -> new RuntimeException("Discente with ID " + id_discente + " not found"));
            discenti_collegati.add(discente_da_collegare);
        }

        // assegno la lista
        nuovo_elemento.setDiscenti(discenti_collegati);

        return nuovo_elemento;
    }

    // --------------------------------------------------------------------------------------------------
}
