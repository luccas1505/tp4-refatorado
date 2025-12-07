package com.tp4refatorado.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SeleniumBasicoTest {

    private WebDriver driver;

    @BeforeAll
    void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/livros");
    }

    @AfterEach
    void close() {
        driver.quit();
    }

    @Test
    void paginaLivrosDeveConterTitulo() {
        String text = driver.getPageSource();
        Assertions.assertTrue(text.contains("Lista de Livros"));
    }
}
