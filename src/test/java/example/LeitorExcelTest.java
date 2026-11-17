
package example;

import org.example.LeitorExcel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeitorExcelTest {

    @Test
    void deveLerPesquisasDaPlanilha() {

        List<String> pesquisas = LeitorExcel.lerPesquisas();

        assertEquals(5, pesquisas.size());

        assertEquals("Selenium WebDriver", pesquisas.get(0));
        assertEquals("Java", pesquisas.get(1));
        assertEquals("Python", pesquisas.get(2));
        assertEquals("Automação de testes", pesquisas.get(3));
        assertEquals("Teste de software", pesquisas.get(4));
    }
}
