package com.tp4refatorado.controller;

import com.tp4refatorado.service.LivroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LivroController.class)
class LivroControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LivroService service;

    @Test
    void deveCarregarPaginaListaLivros() throws Exception {
        mvc.perform(get("/livros"))
                .andExpect(status().isOk())
                .andExpect(view().name("listarLivros"));
    }
}
