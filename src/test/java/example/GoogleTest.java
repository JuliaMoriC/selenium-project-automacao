package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        // Baixa e configura o ChromeDriver automaticamente
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Espera explícita padrão de até 10s
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Opcional: timeout de carregamento de página
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit(); // fecha o browser e encerra o driver
        }
    }

    @Test
    void devePesquisarNoGoogle() {
        driver.get("https://duckduckgo.com");

        WebElement caixa = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );
        caixa.sendKeys("Selenium WebDriver");
        caixa.sendKeys(Keys.ENTER);

        // Resultado carrega
        wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }
}