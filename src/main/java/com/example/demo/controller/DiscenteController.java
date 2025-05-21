package com.example.demo.controller;

import com.example.demo.converter.Converter;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/discenti")
public class DiscenteController {

    @Autowired
    DiscenteService discenteService;
    @Autowired
    Converter converter;


    // GET - tutti i discenti
    @GetMapping("/lista")
    public ResponseEntity<List<DiscenteDTO>> list(@RequestParam(name = "filtro", required = false) String filtro) {
        List<Discente> discenti = new ArrayList<>();

        if ("asc".equalsIgnoreCase(filtro)) {
            discenti = discenteService.ordina_by_nome_asc();
        } else if ("desc".equalsIgnoreCase(filtro)){
            discenti = discenteService.ordina_by_nome_desc();
        } else {
            discenti = discenteService.findAll();
        }

        return ResponseEntity.ok(converter.discente_convert_to_dto(discenti));
    }


    // POST - nuovo docente
    @PostMapping("/new")
    public ResponseEntity<Discente> showAdd(@RequestBody Discente discente) {
        Discente nuovo = discenteService.save(discente);
        return ResponseEntity.ok(nuovo);
    }

    // POST -
    @PostMapping
    public String create(@ModelAttribute("discente") Discente discente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-discente";
        discenteService.save(discente);
        return "redirect:/discenti/lista";
    }


    // PUT - modifica
    @PutMapping("/{id}/edit")
    public ResponseEntity<Discente> showEdit(@PathVariable Long id, @RequestBody Discente aggiornato) {
        Discente discente = discenteService.get(id);

        //
        discente.setNome(aggiornato.getNome());
        discente.setCognome(aggiornato.getCognome());
        discente.setMatricola(aggiornato.getMatricola());
        discente.setEta(aggiornato.getEta());
        discente.setCorsi(aggiornato.getCorsi());

        discenteService.save(discente);
        return ResponseEntity.ok(discente);
    }

//    // AGGIORNA
//    @PostMapping("/{id}")
//    public String update(@PathVariable Long id,
//                         @ModelAttribute("discente") Discente discente,
//                         BindingResult br) {
//        if (br.hasErrors()) return "form-discente";
//        discente.setId(id);
//        discenteService.save(discente);
//        return "redirect:/discenti/lista";
//    }


    // DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }


}

