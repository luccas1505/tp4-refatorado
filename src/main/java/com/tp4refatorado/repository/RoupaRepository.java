package com.tp4refatorado.repository;

import com.tp4refatorado.model.Roupa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoupaRepository {
    private final List<Roupa> roupas = new ArrayList<>();
    private int proxId = 1;

    public void adicionar(Roupa roupa) {
        roupa.setId(proxId++);
        roupas.add(roupa);
    }

    public List<Roupa> listar() {
        return new ArrayList<>(roupas);
    }

    public Optional<Roupa> buscarPorId(int id) {
        return roupas.stream().filter(r -> r.getId() == id).findFirst();
    }

    public boolean atualizar(int id, Roupa novaRoupa) {
        Optional<Roupa> roupaExistente = buscarPorId(id);
        if (roupaExistente.isPresent()) {
            Roupa r = roupaExistente.get();
            r.setNome(novaRoupa.getNome());
            r.setTamanho(novaRoupa.getTamanho());
            r.setPreco(novaRoupa.getPreco());
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        return roupas.removeIf(r -> r.getId() == id);
    }
}
