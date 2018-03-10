package br.com.csvbuilder;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.isNull;

public class CsvBuilder<T> {

    private static final String NEW_LINE = "\n";
    private String delimiter = ";";

    public CsvBuilderElements<T> forElements(Collection<T> elements) {
        return new CsvBuilderElements<>(delimiter, NEW_LINE, elements);
    }

    public CsvBuilder withDelimiter(String separator) {
        if (StringUtils.isEmpty(separator)) {
            throw new IllegalArgumentException("Delimiter cannot be null nor empty.");
        }
        this.delimiter = separator;
        return this;
    }

    public static String[] blankColumns(int size) {
        String[] blankValues = new String[size];
        Arrays.fill(blankValues, "");
        return blankValues;
    }

    public static String[] rightPadding(int size, String... values) {
        if (isNull(values)) {
            throw new IllegalArgumentException("Values cannot be null.");
        }
        if (values.length > size) {
            throw new IllegalArgumentException("Cannot have more values than size.");
        }
        String[] blankValues = blankColumns(size);
        System.arraycopy(values, 0, blankValues, 0, values.length);

        return blankValues;
    }
}
