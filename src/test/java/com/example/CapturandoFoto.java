package com.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CapturandoFoto {
    private WebDriver driver;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
    public void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            Files.createDirectories(Paths.get("screenshots"));

            File destFile = new File("screenshots/" + fileName);
            Files.copy(srcFile.toPath(), destFile.toPath());

            System.out.println("Screenshot salva em: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }

    @Test
    @Order(1)
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();

        // Intencionalmente erro pra demonstrar screenshot
        Assertions.assertEquals("Título errado para falhar o teste", title, () -> {
            takeScreenshot("falha_testGoogleTitle.png");
            return "Título não bateu!";
        });
    }
}
