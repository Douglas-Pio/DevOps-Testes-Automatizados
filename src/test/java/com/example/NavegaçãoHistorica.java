package com.example;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class NavegaçãoHistorica {
     @Test
    public void testNavigationHistory() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://www.mercadolivre.com.br");
        String title1 = driver.getTitle();
        System.out.println("Título inicial: " + title1);

        // 2. Navega para uma página de categoria
        driver.get("https://celulares.mercadolivre.com.br/");
        String title2 = driver.getTitle();
        System.out.println("Título categoria: " + title2);

        
        driver.navigate().back();
        Thread.sleep(3000);  // espera para garantir carregamento
        String titleBack = driver.getTitle();
        System.out.println("Título após voltar: " + titleBack);

     
        driver.navigate().forward();
        Thread.sleep(3000);
        String titleForward = driver.getTitle();
        System.out.println("Título após avançar: " + titleForward);

        // 5. Recarrega a página atual
        driver.navigate().refresh();
        Thread.sleep(3000);
        String titleRefresh = driver.getTitle();
        System.out.println("Título após recarregar: " + titleRefresh);

        // Validações simples para garantir que está na página correta
        assertTrue(title1.toLowerCase().contains("mercado livre"));
        assertTrue(title2.toLowerCase().contains("celulares"));
        assertTrue(titleBack.toLowerCase().contains("mercado livre"));
        assertTrue(titleForward.toLowerCase().contains("celulares"));

        driver.quit();
    }
}
