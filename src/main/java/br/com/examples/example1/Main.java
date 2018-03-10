package br.com.examples.example1;

import br.com.csvbuilder.CsvBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> stringValues = Arrays.asList("Value1", "Value2", "Value3");
        String csv = new CsvBuilder<String>()
                .forElements(stringValues)
                .column(String::toString)
                .column(String::toUpperCase)
                .column(String::toLowerCase)
                .toString();

        System.out.println(csv);
    }
}
