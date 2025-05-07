package com.example.demo.controller;

import com.example.demo.entity.Studente;
import com.example.demo.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/studenti")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    // LISTA - funziona
    @GetMapping("/lista")
    public ModelAndView list(@RequestParam(name = "filtro", required = false) String filtro) {
        ModelAndView modelAndView = new ModelAndView("list-studenti");
        List<Studente> studenti = new ArrayList<>();

        if ("asc".equalsIgnoreCase(filtro)) {
            studenti = studenteService.ordina_by_nome_asc();
        } else if ("desc".equalsIgnoreCase(filtro)){
            studenti = studenteService.ordina_by_nome_desc();
        } else {
            studenti = studenteService.findAll();
        }

        modelAndView.addObject("studenti", studenti);
        return modelAndView;
    }

    /*
    // FORM NUOVO
    @GetMapping("/new")
    public String showAdd(Model model) {
        model.addAttribute("studente", new Studente());
        return "form-studente";
    }

     */


    // FORM NUOVO - funziona
    @GetMapping("/new")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("form-studente");
        modelAndView.addObject("studente", new Studente());
        return modelAndView;
    }


    // SALVA NUOVO - funziona
    @PostMapping
    public String create(@ModelAttribute("studente") Studente studente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-studente";
        studenteService.save(studente);
        return "redirect:/studenti/lista";
    }


    /*
    // FORM EDIT - old
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("studente", studenteService.get(id));
        return "form-studente";
    }
    */


    // FORM EDIT
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("form-studente");
        modelAndView.addObject("studente", studenteService.get(id));
        return modelAndView;
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

