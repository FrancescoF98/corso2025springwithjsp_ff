package com.example.demo.controller;

import com.example.demo.converter.Converter;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Docente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/docenti")
public class DocenteController {

    @Autowired
    DocenteService docenteService;
    @Autowired
    CorsoRepository corsoRepository;
    @Autowired
    Converter converter;

    // LISTA
    @GetMapping("/lista")
    public String list(Model model, @RequestParam(name = "filtro", required = false) String filtro) {
        List<DocenteDTO> docenti = new ArrayList<>();

        if ("asc".equalsIgnoreCase(filtro)) {
            docenti = docenteService.ordina_by_nome_asc();
        } else if ("desc".equalsIgnoreCase(filtro)){
            docenti = docenteService.ordina_by_nome_desc();
        } else {
            docenti = docenteService.findAll();
        }

        model.addAttribute("docenti", docenti);
        return "list-docenti";
    }

    // FORM NUOVO
    @GetMapping("/new")
    public String showAdd(Model model) {
        model.addAttribute("docente", new Docente());
        return "form-docente";
    }

    // SALVA NUOVO
    @PostMapping
    public String create(@ModelAttribute("docente") DocenteDTO docente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-docente";
        docenteService.save(docente);
        return "redirect:/docenti/lista";
    }

    // FORM EDIT
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("docente", docenteService.get(id));
        return "form-docente";
    }

    // AGGIORNA
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("docente") DocenteDTO docente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-docente";
        docente.setId(id);
        docenteService.save(docente);
        return "redirect:/docenti/lista";
    }

    // DELETE
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {

        List<Corso> corsi = corsoRepository.trova_corsi_con_id_docente(id);

        if (corsi.isEmpty()) {
            docenteService.delete(id);
        } else{
            throw new RuntimeException("Impossibile eliminare il docente: ci sono corsi associati.");
        }

        return "redirect:/docenti/lista";

    }





}

