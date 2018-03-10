package br.com.examples.model;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class Person {

    private final String name;
    private final Integer age;
    private final String address;
    private final String city;
    private final String state;


}
