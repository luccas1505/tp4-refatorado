package com.tp4refatorado.integration;

import com.tp4refatorado.service.LivroService;
import com.tp4refatorado.service.RoupaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SistemaIntegradoTest {

    @Autowired
    private LivroService livroService;

    @Autowired
    private RoupaService roupaService;

    @Test
    void deveCarregarContextoEIntegrarSistemas() {
        assertNotNull(livroService);
        assertNotNull(roupaService);
    }
}
