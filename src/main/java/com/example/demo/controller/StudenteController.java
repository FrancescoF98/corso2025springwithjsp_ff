package com.example.demo.controller;

import com.example.demo.entity.Studente;
import com.example.demo.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/studenti")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    // LISTA
    @GetMapping("/lista")
    public String list(Model model) {
        List<Studente> studenti = new ArrayList<>();
        studenti = studenteService.findAll();
        model.addAttribute("studenti", studenti);
        return "list-studenti";
    }

    // FORM NUOVO
    @GetMapping("/new")
    public String showAdd(Model model) {
        model.addAttribute("studente", new Studente());
        return "form-studente";
    }

    // SALVA NUOVO
    @PostMapping
    public String create(@ModelAttribute("studente") Studente studente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-studente";
        studenteService.save(studente);
        return "redirect:/studenti/lista";
    }

    // FORM EDIT
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("studente", studenteService.get(id));
        return "form-studente";
    }

    // AGGIORNA
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("studente") Studente studente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-studente";
        studente.setId(id);
        studenteService.save(studente);
        return "redirect:/studenti/lista";
    }

    // DELETE
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        studenteService.delete(id);
        return "redirect:/studenti/lista";
    }








}

