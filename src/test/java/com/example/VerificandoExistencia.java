package com.example;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerificandoExistencia {
    @Test
    public void testLoginForm() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Abre a página de login
        driver.get("https://www.google.com.br");

        
        // Aguarda um pouco e verifica se o login foi bem-sucedido
        Thread.sleep(2000);
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("You logged into a secure area!"));

        driver.quit();
    }
}

