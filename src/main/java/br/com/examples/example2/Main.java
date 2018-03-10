package br.com.examples.example2;

import br.com.csvbuilder.CsvBuilder;
import br.com.examples.model.Person;
import br.com.examples.model.SomeRandomClass;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<SomeRandomClass> listOfRandomClass = randomClasses(5);

        String csv = new CsvBuilder<SomeRandomClass>()
                .forElements(listOfRandomClass)
                .column(randomClass -> randomClass.getRandomStringValue())
                .column(randomClass -> randomClass.getRandomIntegerValue().toString())
                .column(randomClass -> randomClass.getRandomDoubleValue().toString())
                .toString();

        System.out.println(csv);
    }

    private static List<SomeRandomClass> randomClasses(Integer size) {
        List<SomeRandomClass> people = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            people.add(radomClass(i));
        }

        return people;
    }

    private static SomeRandomClass radomClass(Integer value) {
        return SomeRandomClass.builder()
                .randomStringValue(value + "_Value")
                .randomIntegerValue(value)
                .randomDoubleValue(value.doubleValue())
                .build();
    }
}
