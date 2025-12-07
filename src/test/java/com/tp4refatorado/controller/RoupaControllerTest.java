package com.tp4refatorado.controller;

import com.tp4refatorado.service.RoupaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoupaController.class)
class RoupaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RoupaService service;

    @Test
    void deveCarregarListaRoupas() throws Exception {
        mvc.perform(get("/roupas"))
                .andExpect(status().isOk())
                .andExpect(view().name("listarRoupas"));
    }
}
