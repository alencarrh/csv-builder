package br.com.csvbuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvBuilderElements<T> {

    private final String delimiter;
    private final String endLine;
    private final CsvSimpleRows headers;
    private final Collection<T> elements;
    private final CsvSimpleRows footers;
    private final Collection<Function<T, String>> columns;

    CsvBuilderElements(String delimiter, String endLine, Collection<T> elements) {
        this.delimiter = delimiter;
        this.endLine = endLine;
        this.elements = elements;
        this.headers = new CsvSimpleRows(delimiter, endLine);
        this.footers = new CsvSimpleRows(delimiter, endLine);
        this.columns = new ArrayList<>();
    }

    /**
     * Add a header.
     *
     * @param header String... represents the columns for the header.
     * @return
     */
    public CsvBuilderElements<T> header(String... header) {
        this.headers.addRow(header);
        return this;
    }

    /**
     * Add a footer.
     *
     * @param footer String... represents the columns for the footer.
     * @return
     */
    public CsvBuilderElements<T> footer(String... footer) {
        this.footers.addRow(footer);
        return this;
    }

    /**
     * Add a column.
     *
     * @param column Function<T,R> to get the value of the column
     * @return
     */
    public CsvBuilderElements<T> column(Function<T, String> column) {
        this.columns.add(column);
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder csv = new StringBuilder();

        String finalHeader = headers.toString();
        String finalRows = buildRows();
        String finalFooter = footers.toString();

        csv.append(finalHeader)
                .append(finalRows)
                .append(finalFooter);

        return csv.toString();
    }

    private String buildRows() {
        if (this.columns.isEmpty()) {
            return "";
        }
        ArrayList<String> rows = new ArrayList<>();
        this.elements.forEach(element -> {
            rows.add(buildRow(element));
        });

        return String.join(endLine, rows) + endLine;
    }

    private String buildRow(T element) {
        return this.columns.stream()
                .map(columnFunction -> columnFunction.apply(element))
                .collect(Collectors.joining(this.delimiter));
    }

}
