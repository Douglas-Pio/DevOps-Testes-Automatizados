package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void verificarTituloDoGoogle() {
        driver.get("https://www.google.com");
        String titulo = driver.getTitle();
        System.out.println("Título da página: " + titulo);
        assertEquals("Google", titulo, "O título da página não é o esperado.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

