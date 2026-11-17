
package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        List<String[]> resultados = new ArrayList<>();

        try {
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(15)
            );

            List<String> pesquisas = LeitorExcel.lerPesquisas();

            for (String pesquisa : pesquisas) {

                System.out.println("Pesquisando: " + pesquisa);

                driver.get("https://duckduckgo.com");

                WebElement caixa = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        By.name("q")
                    )
                );

                caixa.sendKeys(pesquisa);
                caixa.sendKeys(Keys.ENTER);

                wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                        By.id("search")
                    )
                );

                wait.until(d ->
                    !d.findElements(
                        By.cssSelector("#search h3")
                    ).isEmpty()
                );

                List<WebElement> titulos = driver.findElements(
                    By.cssSelector("#search h3")
                );

                for (WebElement titulo : titulos) {

                    try {
                        String texto = titulo.getText();

                        WebElement link = titulo.findElement(
                            By.xpath("./ancestor::a[1]")
                        );

                        String url = link.getAttribute("href");

                        if (texto != null && !texto.isBlank()
                                && url != null) {

                            resultados.add(new String[]{
                                pesquisa, texto, url
                            });

                            System.out.println("Resultado: " + texto);
                        }

                    } catch (NoSuchElementException e) {
                        System.out.println(
                            "Resultado sem link ignorado."
                        );
                    }
                }

                System.out.println(
                    "Pesquisa concluída: " + pesquisa
                );
            }

            salvarExcel(resultados);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }
    }

    public static void salvarExcel(List<String[]> resultados) {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet planilha = workbook.createSheet("Resultados");

            Row cabecalho = planilha.createRow(0);

            cabecalho.createCell(0).setCellValue("Pesquisa");
            cabecalho.createCell(1).setCellValue("Título");
            cabecalho.createCell(2).setCellValue("Link");

            int linha = 1;

            for (String[] resultado : resultados) {

                Row row = planilha.createRow(linha++);

                row.createCell(0).setCellValue(resultado[0]);
                row.createCell(1).setCellValue(resultado[1]);
                row.createCell(2).setCellValue(resultado[2]);
            }

            for (int i = 0; i < 3; i++) {
                planilha.autoSizeColumn(i);
            }

            try (FileOutputStream arquivo =
                    new FileOutputStream("resultados.xlsx")) {

                workbook.write(arquivo);
            }

            System.out.println(
                "Planilha resultados.xlsx criada com sucesso!"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
