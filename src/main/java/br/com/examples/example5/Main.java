package br.com.examples.example5;

import br.com.csvbuilder.CsvBuilder;
import br.com.examples.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = people(5);
        String[] columnsName = {"Name", "Age", "Address", "City", "State"};
        String csv = new CsvBuilder<Person>()
                .forElements(people)
                .header(columnsName)
                .header("1", "2", "3")
                .header("1", "2", "3", "4", "5")
                .header("1", "2", "3", "4", "5", "6")
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
