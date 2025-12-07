package com.tp4refatorado.repository;

import com.tp4refatorado.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository  // <- muito importante para o Spring reconhecer!
public class LivroRepository {

    private final List<Livro> livros = new ArrayList<>();
    private int proxId = 1;

    public void adicionar(Livro livro) {
        livro.setId(proxId++);
        livros.add(livro);
    }

    public List<Livro> listar() {
        return new ArrayList<>(livros);
    }

    public Optional<Livro> buscarPorId(int id) {
        return livros.stream().filter(l -> l.getId() == id).findFirst();
    }

    public boolean atualizar(int id, Livro novoLivro) {
        Optional<Livro> livroExistente = buscarPorId(id);
        if (livroExistente.isPresent()) {
            Livro l = livroExistente.get();
            l.setTitulo(novoLivro.getTitulo());
            l.setAutor(novoLivro.getAutor());
            l.setPreco(novoLivro.getPreco());
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        return livros.removeIf(l -> l.getId() == id);
    }
}
