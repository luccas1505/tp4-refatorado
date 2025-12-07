package com.tp4refatorado.service;

import com.tp4refatorado.model.Livro;
import com.tp4refatorado.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LivroServiceTest {

    @Mock
    private LivroRepository repository;

    @InjectMocks
    private LivroService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarLivroComSucesso() {
        Livro livro = new Livro(1, "Teste", "Autor", 50);

        doNothing().when(repository).adicionar(livro);

        service.salvar(livro);

        verify(repository, times(1)).adicionar(livro);
    }

    @Test
    void deveLancarErroAoAtualizarIdInexistente() {
        when(repository.atualizar(anyInt(), any())).thenReturn(false);

        boolean resultado = service.atualizar(99, new Livro());

        assertFalse(resultado);
    }

    @Test
    void deveFalharNoDeleteQuandoIdNaoExiste() {
        when(repository.deletar(anyInt())).thenReturn(false);

        boolean resultado = service.deletar(123);

        assertFalse(resultado);
    }

    @Test
    void deveTratarErroInesperadoGracefully() {
        doThrow(new RuntimeException("Erro inesperado"))
                .when(repository).adicionar(any());

        assertThrows(RuntimeException.class, () -> {
            service.salvar(new Livro());
        });
    }
}
