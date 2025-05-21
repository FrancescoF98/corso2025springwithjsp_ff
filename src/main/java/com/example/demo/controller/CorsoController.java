package com.example.demo.controller;

import com.example.demo.converter.Converter;
import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Docente;
import com.example.demo.data.entity.Discente;
import com.example.demo.service.CorsoService;
import com.example.demo.service.DocenteService;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CorsoDTO> list(@RequestParam(name = "filtro", required = false) String filtro) {
        List<Corso> corsi = new ArrayList<>();

        if ("asc".equalsIgnoreCase(filtro)) {
            corsi = corsoService.ordina_by_nome_asc();
        } else if ("desc".equalsIgnoreCase(filtro)){
            corsi = corsoService.ordina_by_nome_desc();
        } else {
            corsi = corsoService.findAll();
        }

        return converter.corso_convert_to_dto(corsi);

    }


    // FORM NUOVO
    @GetMapping("/new")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("form-corso");
        List<Docente> docenti = docenteService.findAll();

        modelAndView.addObject("corso", new Corso());
        modelAndView.addObject("docenti", docenti);
        modelAndView.addObject("discenti", discenteService.findAll());

        return modelAndView;
    }


    // SALVA NUOVO
    @PostMapping
    public String create(@ModelAttribute("corso") Corso corso,
                         @RequestParam(value = "discenti", required = false) List<Long> id_discenti,
                         BindingResult br) {
        if (br.hasErrors()) return "form-corso";

        if (id_discenti != null) {
            List<Discente> selectedDiscenti = discenteService.findAllByIds(id_discenti);
            corso.setDiscenti(selectedDiscenti);
        }

        corsoService.save(corso);
        return "redirect:/corsi/lista";
    }


    /*
    // FORM EDIT - old
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("corso", corsoService.get(id));
        return "form-corso";
    }
    */


    // FORM EDIT
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("form-corso");
        List<Docente> docenti = docenteService.findAll();

        modelAndView.addObject("corso", corsoService.get(id));
        modelAndView.addObject("docenti", docenti);
        modelAndView.addObject("discenti", discenteService.findAll());

        return modelAndView;
    }



    // AGGIORNA
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("corso") Corso corso,
                         BindingResult br) {
        if (br.hasErrors()) return "form-corso";
        corso.setId(id);
        corsoService.save(corso);
        return "redirect:/corsi/lista";
    }

    // DELETE
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        corsoService.delete(id);
        return "redirect:/corsi/lista";
    }





}

