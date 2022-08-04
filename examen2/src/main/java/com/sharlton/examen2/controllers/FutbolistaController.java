package com.sharlton.examen2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sharlton.examen2.models.Futbolista;
import com.sharlton.examen2.services.IFutbolistaService;
import com.sharlton.examen2.services.IIMCService;

@Controller
@RequestMapping("futbolistas")
public class FutbolistaController {
    @Autowired
    IFutbolistaService futbolistaService;

    @Autowired
    IIMCService imcService;

    @RequestMapping("listar")
    private String listar(Model model){
        List<Futbolista> lista = futbolistaService.buscar();
        model.addAttribute("lista", lista);
        return "futbolistas/listar";
    }

    @RequestMapping("buscar")
    private String buscar(Model model) {
        model.addAttribute("futbolista", new Futbolista());
        return "futbolistas/buscar";
    }

    @RequestMapping("detalle/{id}")
    private String buscar(Model model, @PathVariable long id){
        Optional<Futbolista> optFutbolista = futbolistaService.buscar(id);
        if (optFutbolista.isEmpty()) return "notFound";

        Futbolista futbolista =  new Futbolista();
        futbolista = (Futbolista) optFutbolista.get();
        //futbolista.getLastImc(); // TODO: aaa
        model.addAttribute("futbolista", futbolista);
        return "futbolistas/detalle";
    }

    @RequestMapping("registrar")
    private String registrar(Model model){
        Futbolista futbolista = new Futbolista();
        model.addAttribute("futbolista", futbolista);
        return "futbolistas/registrar";
    }

    @RequestMapping("actualizar/{id}")
    private String actualizar(Model model, @PathVariable long id){
        Optional<Futbolista> optFutbolista = futbolistaService.buscar(id);
        if (optFutbolista.isEmpty()) return "notFound";

        Futbolista futbolista = new Futbolista();
        model.addAttribute("original", optFutbolista.get());
        model.addAttribute("futbolista", futbolista);
        return "futbolistas/actualizar";
    }

    /* API */ 

    @GetMapping("/")
    private String filtrar(Model model, @RequestParam(value = "texto", required = false) String texto){
        Futbolista futbolista = new Futbolista();
        futbolista.setNombre(texto);
        futbolista.setApellido1(texto);
        List<Futbolista> lista = futbolistaService.buscar(futbolista);
        model.addAttribute("lista", lista);
        return "futbolistas/listar";
    }

    @PostMapping("/")
    private String registrar(Futbolista futbolista){
        futbolistaService.crear(futbolista);
        imcService.registrarImc(futbolista);
        return "exito";
    }

    @PostMapping("/actualizar/{id}")
    private String actualizar(Futbolista futbolista, @PathVariable long id) {
        Optional<Futbolista> optFutbolista = futbolistaService.buscar(id);
        if (optFutbolista.isEmpty()) return "notFound";

        Futbolista nuevoFutbolista = optFutbolista.get();
        futbolista.setNombre(nuevoFutbolista.getNombre());
        futbolista.setApellido1(nuevoFutbolista.getApellido1());
        futbolista.setApellido2(nuevoFutbolista.getApellido2());
        futbolista.setRama(nuevoFutbolista.getRama());
        futbolista.setPosicion(nuevoFutbolista.getPosicion());
        futbolista.setEstatura(nuevoFutbolista.getEstatura());
        futbolista.setFechaNacimiento(nuevoFutbolista.getFechaNacimiento());
        if ( Double.compare(futbolista.getPeso(), nuevoFutbolista.getPeso()) != 0){
            imcService.registrarImc(futbolista);
        }
        futbolistaService.actualizar(futbolista);
        return "exito";
    }
}
