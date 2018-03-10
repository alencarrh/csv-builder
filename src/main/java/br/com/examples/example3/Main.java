package br.com.examples.example3;

import br.com.csvbuilder.CsvBuilder;
import br.com.examples.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = people(5);

        String csv = new CsvBuilder<Person>()
                .forElements(people)
                .column(Person::getName)
                .column(p -> p.getAge().toString())
                .column(Person::getAddress)
                .column(Person::getCity)
                .column(Person::getState)
                .toString();

        System.out.println(csv);
    }

    private static List<Person> people(Integer size) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            people.add(buildPerson(i));
        }

        return people;
    }

    private static Person buildPerson(Integer value) {
        return Person.builder()
                .name("Name" + value)
                .age(value)
                .address("Address" + value)
                .city("City" + value)
                .state("State" + 1)
                .build();
    }
}
