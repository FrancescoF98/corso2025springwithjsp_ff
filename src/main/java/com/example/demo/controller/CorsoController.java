package com.example.demo.controller;

import com.example.demo.converter.Converter;
import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Docente;
import com.example.demo.data.entity.Discente;
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
    public ResponseEntity<Corso> showAdd(@RequestBody Corso corso) {
        Corso nuovo = corsoService.save(corso);
        return ResponseEntity.ok(nuovo);
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
    public ResponseEntity<Corso> showEdit(@PathVariable Long id, @RequestBody Corso aggiornato) {
        Corso corso = corsoService.get(id);

        //
        corso.setNome(aggiornato.getNome());
        corso.setId_doc(aggiornato.getId_doc());
        corso.setAnno_accademico(aggiornato.getAnno_accademico());
        corso.setDiscenti(aggiornato.getDiscenti());

        corsoService.save(corso);
        return ResponseEntity.ok(corso);
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
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        corsoService.delete(id);
        return "redirect:/corsi/lista";
    }





}

