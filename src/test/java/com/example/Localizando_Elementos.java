package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Localizando_Elementos {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
       
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testPesquisarNoGoogle() throws InterruptedException {
        
        driver.get("https://www.google.com");

       
        // Localiza o campo de busca pelo nome
        WebElement campoBusca = driver.findElement(By.name("q"));

        // Digita "Selenium WebDriver"
        campoBusca.sendKeys("Selenium WebDriver");


    
        Thread.sleep(3000);

        // Verifica se algum resultado foi exibido
        String titulo = driver.getTitle();
        System.out.println("Título da página de resultados: " + titulo);
        assertTrue(titulo.contains("Selenium WebDriver"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

