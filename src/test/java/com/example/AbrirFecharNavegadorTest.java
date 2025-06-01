package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AbrirFecharNavegadorTest {

    @Test
    void abrirEFecharChrome() throws InterruptedException {
        
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Thread.sleep(5000); // espera 5 segundos

        driver.quit(); // fecha o navegador
    }
}
