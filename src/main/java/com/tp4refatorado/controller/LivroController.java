package com.tp4refatorado.controller;

import com.tp4refatorado.model.Livro;
import com.tp4refatorado.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", service.listar());
        return "listarLivros";
    }

    @GetMapping("/novo")
    public String criarForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "formLivro";
    }

    @PostMapping
    public String salvar(@ModelAttribute Livro livro) {
        service.salvar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model) {
        Livro livro = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        model.addAttribute("livro", livro);
        return "formLivro";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Livro livro) {
        service.atualizar(id, livro);
        return "redirect:/livros";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        service.deletar(id);
        return "redirect:/livros";
    }
}
