package com.example.demo.controller;

import com.example.demo.config.CustomConfig;
import com.example.demo.converter.Converter;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/docenti")
public class DocenteController {

    @Autowired
    DocenteService docenteService;
    @Autowired
    CorsoRepository corsoRepository;
    @Autowired
    Converter converter;

    private final CustomConfig config;

    public DocenteController(CustomConfig config) {
        this.config = config;
    }

    @GetMapping("/")
    public String message() {
        return config.getMessage();
    }

    // GET - tutti i docenti
    @GetMapping("/lista")
    public ResponseEntity<List<DocenteDTO>> list(@RequestParam(name = "filtro", required = false) String filtro) {
        List<Docente> docenti = new ArrayList<>();

        if ("asc".equalsIgnoreCase(filtro)) {
            docenti = docenteService.ordina_by_nome_asc();
        } else if ("desc".equalsIgnoreCase(filtro)){
            docenti = docenteService.ordina_by_nome_desc();
        } else {
            docenti = docenteService.findAll();
        }

        return ResponseEntity.ok(converter.docente_convert_to_dto(docenti));
    }

    // POST - nuovo docente
    @PostMapping("/new")
    public ResponseEntity<DocenteDTO> showAdd(@RequestBody DocenteDTO docente) {
        // converto
        Docente nuovo = converter.docente_convert_to_entity(docente);
        // salvo
        docenteService.save(nuovo);
        //
        return ResponseEntity.ok(docente);
    }

    // PUT - modifica
    @PutMapping("/{id}/edit")
    public ResponseEntity<DocenteDTO> showEdit(@PathVariable Long id, @RequestBody DocenteDTO doc_aggiornato) {
        // questa linea non ha senso ma funziona e la lascio così - 2025/05/26
        DocenteDTO docente = converter.docente_convert_to_dto(docenteService.get(id));

        //
        docente.setNome(doc_aggiornato.getNome());
        docente.setCognome(doc_aggiornato.getCognome());

        Docente modificato = converter.docente_convert_to_entity(docente);

        docenteService.save(modificato);
        return ResponseEntity.ok(docente);

    }


    // DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        List<Corso> corsi = corsoRepository.trova_corsi_con_id_docente(id);

        if (corsi.isEmpty()) {
            docenteService.delete(id);
        } else{
            throw new RuntimeException("Impossibile eliminare il docente: ci sono corsi associati.");
        }

        return ResponseEntity.noContent().build();
    }




}

