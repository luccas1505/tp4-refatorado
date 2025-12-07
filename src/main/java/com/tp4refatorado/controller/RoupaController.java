package com.tp4refatorado.controller;

import com.tp4refatorado.model.Roupa;
import com.tp4refatorado.service.RoupaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roupas")
public class RoupaController {

    private final RoupaService service;

    public RoupaController(RoupaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("roupas", service.listar());
        return "listarRoupas";
    }

    @GetMapping("/novo")
    public String formNova(Roupa roupa) {
        return "formRoupa";
    }

    @PostMapping
    public String salvar(Roupa roupa) {
        service.salvar(roupa);
        return "redirect:/roupas";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable int id, Model model) {
        Roupa roupa = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("roupa", roupa);
        return "formRoupa";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, Roupa roupa) {
        service.atualizar(id, roupa);
        return "redirect:/roupas";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        service.deletar(id);
        return "redirect:/roupas";
    }
}
