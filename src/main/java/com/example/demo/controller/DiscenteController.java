package com.example.demo.controller;

import com.example.demo.entity.Discente;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/discenti")
public class DiscenteController {

    @Autowired
    DiscenteService discenteService;




    // LISTA - funziona
    @GetMapping("/lista")
    public ModelAndView list(@RequestParam(name = "filtro", required = false) String filtro) {
        ModelAndView modelAndView = new ModelAndView("list-discenti");
        List<Discente> discenti = new ArrayList<>();

        if ("asc".equalsIgnoreCase(filtro)) {
            discenti = discenteService.ordina_by_nome_asc();
        } else if ("desc".equalsIgnoreCase(filtro)){
            discenti = discenteService.ordina_by_nome_desc();
        } else {
            discenti = discenteService.findAll();
        }

        modelAndView.addObject("discenti", discenti);
        return modelAndView;
    }

    /*
    // FORM NUOVO
    @GetMapping("/new")
    public String showAdd(Model model) {
        model.addAttribute("discente", new Discente());
        return "form-discente";
    }

    */


    // FORM NUOVO - funziona
    @GetMapping("/new")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("form-discente");
        modelAndView.addObject("discente", new Discente());
        return modelAndView;
    }


    // SALVA NUOVO - funziona
    @PostMapping
    public String create(@ModelAttribute("discente") Discente discente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-discente";
        discenteService.save(discente);
        return "redirect:/discenti/lista";
    }


    /*
    // FORM EDIT - old
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("discente", discenteService.get(id));
        return "form-discente";
    }
    */


    // FORM EDIT
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("form-discente");
        modelAndView.addObject("discente", discenteService.get(id));
        return modelAndView;
    }



    // AGGIORNA
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("discente") Discente discente,
                         BindingResult br) {
        if (br.hasErrors()) return "form-discente";
        discente.setId(id);
        discenteService.save(discente);
        return "redirect:/discenti/lista";
    }

    // DELETE
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        discenteService.delete(id);
        return "redirect:/discenti/lista";
    }








}

