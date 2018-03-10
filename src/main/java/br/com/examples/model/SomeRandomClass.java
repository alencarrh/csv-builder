package br.com.examples.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SomeRandomClass {


    private final String randomStringValue;
    private final Integer randomIntegerValue;
    private final Double randomDoubleValue;


}
