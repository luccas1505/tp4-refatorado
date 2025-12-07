package com.tp4refatorado.service;

import com.tp4refatorado.model.Roupa;
import com.tp4refatorado.repository.RoupaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoupaServiceTest {

    @Mock
    private RoupaRepository repository;

    @InjectMocks
    private RoupaService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarRoupa() {
        Roupa r = new Roupa();

        doNothing().when(repository).adicionar(r);

        service.salvar(r);

        verify(repository, times(1)).adicionar(r);
    }

    @Test
    void deveRetornarFalseParaUpdateDeIdInvalido() {
        when(repository.atualizar(anyInt(), any())).thenReturn(false);

        boolean ok = service.atualizar(55, new Roupa());

        assertFalse(ok);
    }

    @Test
    void deveRetornarFalseAoDeletarIdInexistente() {
        when(repository.deletar(anyInt())).thenReturn(false);

        assertFalse(service.deletar(10));
    }
}
