package br.com.csvbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class CsvSimpleRows {

    private final String delimiter;
    private final String endLine;
    private final Collection<Collection<String>> rows;

    CsvSimpleRows(String delimiter, String endLine) {
        this.delimiter = delimiter;
        this.endLine = endLine;
        this.rows = new ArrayList<>();
    }

    public void addRow(String... row) {
        this.rows.add(Arrays.asList(row));
    }

    public void addRow(Collection<String> row) {
        this.rows.add(row);
    }

    public boolean isEmpty() {
        return this.rows.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        String toString = this.rows.stream()
                .map(row -> String.join(delimiter, row))
                .collect(Collectors.joining(endLine));

        return toString + endLine;

    }

}
