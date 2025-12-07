package com.tp4refatorado.service;

import com.tp4refatorado.model.Roupa;
import com.tp4refatorado.repository.RoupaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoupaService {

    private final RoupaRepository repository;

    public RoupaService(RoupaRepository repository) {
        this.repository = repository;
    }

    public List<Roupa> listar() {
        return repository.listar();
    }

    public Optional<Roupa> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public void salvar(Roupa roupa) {
        repository.adicionar(roupa);
    }

    public boolean atualizar(int id, Roupa roupaAtualizada) {
        return repository.atualizar(id, roupaAtualizada);
    }

    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
