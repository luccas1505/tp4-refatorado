package com.tp4refatorado.service;

import com.tp4refatorado.model.Livro;
import com.tp4refatorado.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listar() {
        return repository.listar();
    }

    public Optional<Livro> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public void salvar(Livro livro) {
        repository.adicionar(livro);
    }

    public boolean atualizar(int id, Livro livroAtualizado) {
        return repository.atualizar(id, livroAtualizado);
    }

    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
