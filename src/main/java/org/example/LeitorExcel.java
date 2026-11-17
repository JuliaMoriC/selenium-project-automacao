
package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorExcel {

    public static List<String> lerPesquisas() {

        List<String> pesquisas = new ArrayList<>();

        String caminho = "dados.xlsx";

        try (FileInputStream arquivo = new FileInputStream(caminho);
             Workbook workbook = new XSSFWorkbook(arquivo)) {

            Sheet planilha = workbook.getSheetAt(0);

            for (int i = 1; i <= planilha.getLastRowNum(); i++) {

                Row linha = planilha.getRow(i);

                if (linha != null) {
                    Cell celula = linha.getCell(0);

                    if (celula != null) {
                        String pesquisa = celula.toString().trim();

                        if (!pesquisa.isEmpty()) {
                            pesquisas.add(pesquisa);
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(
                "Erro ao ler a planilha Excel: " + caminho, e
            );
        }

        return pesquisas;
    }
}
