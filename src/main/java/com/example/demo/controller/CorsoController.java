package com.example.demo.controller;

import com.example.demo.converter.Converter;
import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Docente;
import com.example.demo.data.entity.Discente;
import com.example.demo.repository.DiscenteRepository;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.service.CorsoService;
import com.example.demo.service.DocenteService;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/corsi")
public class CorsoController {

    @Autowired
    CorsoService corsoService;

    @Autowired
    DocenteService docenteService;

    @Autowired
    DiscenteService discenteService;

    @Autowired
    Converter converter;

    @Autowired
    DocenteRepository docenteRepository;
    @Autowired
    DiscenteRepository discenteRepository;

    // LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<CorsoDTO>> list(@RequestParam(name = "filtro", required = false) String filtro) {
        List<Corso> corsi = new ArrayList<>();

        if ("asc".equalsIgnoreCase(filtro)) {
            corsi = corsoService.ordina_by_nome_asc();
        } else if ("desc".equalsIgnoreCase(filtro)){
            corsi = corsoService.ordina_by_nome_desc();
        } else {
            corsi = corsoService.findAll();
        }

        return ResponseEntity.ok(converter.corso_convert_to_dto(corsi));

    }


    // POST - nuovo
    @PostMapping("/new")
    public ResponseEntity<CorsoDTO> showAdd(@RequestBody CorsoDTO corso) {

        System.out.println("ID (prima):" + corso.getId_doc().getId());
        System.out.println("Nome (prima):" + corso.getId_doc().getNome());
        System.out.println("Cognome (prima):" + corso.getId_doc().getCognome());

        // converto
        Corso nuovo = converter.corso_convert_to_entity(corso);

        System.out.println("ID (dopo):" + corso.getId_doc().getId());
        System.out.println("Nome (dopo):" + corso.getId_doc().getNome());
        System.out.println("Cognome (dopo):" + corso.getId_doc().getCognome());

        // salvo
        corsoService.save(nuovo);
        //
        return ResponseEntity.ok(corso);
    }

//    // POST -
//    @PostMapping
//    public String create(@ModelAttribute("corso") Corso corso,
//                         @RequestParam(value = "discenti", required = false) List<Long> id_discenti,
//                         BindingResult br) {
//        if (br.hasErrors()) return "form-corso";
//
//        if (id_discenti != null) {
//            List<Discente> selectedDiscenti = discenteService.findAllByIds(id_discenti);
//            corso.setDiscenti(selectedDiscenti);
//        }
//
//        corsoService.save(corso);
//        return "redirect:/corsi/lista";
//    }


    // PUT - modifica
    @PutMapping("/{id}/edit")
    public ResponseEntity<CorsoDTO> showEdit(@PathVariable Long id, @RequestBody CorsoDTO aggiornato) {
        Corso corso = corsoService.get(id);

        //
        corso.setNome(aggiornato.getNome());
        corso.setAnno_accademico(aggiornato.getAnno_accademico());

        /// --- Per assegnare il Docente a partire da un DocenteDTO
        Long id_docente = aggiornato.getId_doc().getId();
        Docente docente_da_collegare = docenteRepository.findById(id_docente)
                .orElseThrow(() -> new RuntimeException("Docente with ID " + id_docente + " not found"));
        corso.setId_doc(docente_da_collegare);

        /// --- Per assegnare i Discenti a partire da una lista di DiscentiDTO
        List<Discente> discenti_collegati = new ArrayList<>();
        for (int i = 0; i < aggiornato.getDiscenti().size(); i++) {
            Long id_discente = aggiornato.getDiscenti().get(i).getId();
            Discente discente_da_collegare = discenteRepository.findById(id_discente)
                    .orElseThrow(() -> new RuntimeException("Discente with ID " + id_discente + " not found"));
            discenti_collegati.add(discente_da_collegare);
        }

        // assegno la lista
        corso.setDiscenti(discenti_collegati);

        corsoService.save(corso);
        return ResponseEntity.ok(aggiornato);
    }


//    // AGGIORNA
//    @PostMapping("/{id}")
//    public String update(@PathVariable Long id,
//                         @ModelAttribute("corso") Corso corso,
//                         BindingResult br) {
//        if (br.hasErrors()) return "form-corso";
//        corso.setId(id);
//        corsoService.save(corso);
//        return "redirect:/corsi/lista";
//    }


    // DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        corsoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

