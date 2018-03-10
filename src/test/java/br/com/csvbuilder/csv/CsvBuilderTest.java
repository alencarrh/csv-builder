package br.com.csvbuilder.csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import br.com.csvbuilder.CsvBuilder;
import br.com.csvbuilder.CsvBuilderElements;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;
public class CsvBuilderTest {

    private Collection<String> elements;
    private final String delimiter = ";";
    private final String newLine = "\n";

    @Before
    public void setup() {
        elements = new ArrayList<>();
        for (int i = 0; i < nextInt(10, 30); i++) {
            elements.add(randomAlphanumeric(5));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarException() {
        new CsvBuilder().withDelimiter(null);
    }

    @Test
    public void deveRetornarEmpty() {
        String csv = getCsvBuilderElements().toString();
        assertEquals("", csv);
    }

    @Test
    public void deveRetornarOkUmaColunaSomenteElementos() {
        CsvBuilderElements<String> builder = getCsvBuilderElements();
        String csvEsperado = String.join(newLine, elements) + newLine;

        String csv = builder.column(value -> value).toString();
        assertEquals(csvEsperado, csv);
    }

    @Test
    public void deveRetornarOkDuasColunasSomenteElementos() {
        CsvBuilderElements<String> builder = getCsvBuilderElements();
        final StringBuilder csvEsperado = new StringBuilder();

        elements.forEach(element -> {
            csvEsperado.append(element)
                    .append(delimiter)
                    .append(element.toUpperCase())
                    .append(newLine);
        });
        
        String csv = builder.column(value -> value)
                .column(String::toUpperCase)
                .toString();
        
        assertEquals(csvEsperado.toString(), csv);
    }

    
    @Test
    public void deveRetornarOkHeader(){
        CsvBuilderElements<String> builder = new CsvBuilder().withDelimiter(delimiter).forElements(Arrays.asList("A"));
        
        String csvEsperado = "header1;;"+newLine
                           + "A;a;A"+newLine;

        String csv = builder.header("header1", "", "")
                            .column(value -> value)
                            .column(String::toLowerCase)
                            .column(String::toUpperCase)
                            .toString();

        assertEquals(csvEsperado, csv);
    }
    
    @Test
    public void deveRetornarOkFooter(){
        CsvBuilderElements<String> builder = new CsvBuilder().withDelimiter(delimiter).forElements(Arrays.asList("A"));
        
        String csvEsperado = "A;a;A"+newLine
                           + "footer1;;"+newLine;

        String csv = builder.column(value -> value)
                            .column(String::toLowerCase)
                            .column(String::toUpperCase)
                            .footer("footer1", "", "")
                            .toString();
        
        assertEquals(csvEsperado, csv);
    }
    
    private CsvBuilderElements<String> getCsvBuilderElements() {
        return new CsvBuilder().withDelimiter(delimiter).forElements(elements);
    }
}
