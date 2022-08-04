package com.sharlton.examen2.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharlton.examen2.models.Futbolista;
import com.sharlton.examen2.services.IFutbolistaService;

@Controller
@RequestMapping("imc")
public class IMCController {
    @Autowired
    IFutbolistaService futbolistaService;

    @RequestMapping("/historial/{id}")
    private String historial(Model model, @PathVariable long id){
        Optional<Futbolista> optFutbolista = futbolistaService.buscar(id);
        if (optFutbolista.isEmpty()) return "notFound";
        model.addAttribute("lista", optFutbolista.get().getImc());
        model.addAttribute("futbolista", optFutbolista.get());
        return "imc/historial";
    }
    
}
