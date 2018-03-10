# CsvBuilder

This is a simple csv builder with Java 8.


## How to use

### Example 1

See all the code for example 1 [here](src/main/java/br/com/examples/example1/Main.java)

#### Code
```java
List<String> stringValues = Arrays.asList("Value1", "Value2", "Value3");
new CsvBuilder<String>()
    .forElements(stringValues)
    .column(String::toString)
    .column(String::toUpperCase)
    .column(String::toLowerCase)
    .toString();
```
#### Response
```
Value1;VALUE1;value1
Value2;VALUE2;value2
Value3;VALUE3;value3
```

### Example 2

See all the code for example 2 [here](src/main/java/br/com/examples/example2/Main.java)

#### Code
```java
new CsvBuilder<SomeRandomClass>()
    .forElements(listOfRandomClass)
    .column(randomClass -> randomClass.getRandomStringValue())
    .column(randomClass -> randomClass.getRandomIntegerValue().toString())
    .column(randomClass -> randomClass.getRandomDoubleValue().toString())
    .toString();
```
#### Response
```
0_Value;0;0.0
1_Value;1;1.0
2_Value;2;2.0
3_Value;3;3.0
4_Value;4;4.0
```

### Example 3

See all the code for example 3 [here](src/main/java/br/com/examples/example3/Main.java)

#### Code
```java
new CsvBuilder<Person>()
    .forElements(people)
    .column(Person::getName)
    .column(p -> p.getAge().toString())
    .column(Person::getAddress)
    .column(Person::getCity)
    .column(Person::getState)
    .toString();

```
#### Response
```
Name0;0;Address0;City0;State1
Name1;1;Address1;City1;State1
Name2;2;Address2;City2;State1
Name3;3;Address3;City3;State1
Name4;4;Address4;City4;State1
```

### Example 4

See all the code for example 4 [here](src/main/java/br/com/examples/example4/Main.java)

#### Code
```java
String[] columnsName = {"Name","Age","Address","City","State"};
new CsvBuilder<Person>()
    .forElements(people)
    .header(columnsName)
    .column(Person::getName)
    .column(p -> p.getAge().toString())
    .column(Person::getAddress)
    .column(Person::getCity)
    .column(Person::getState)
    .toString();
```
#### Response
```
Name;Age;Address;City;State
Name0;0;Address0;City0;State1
Name1;1;Address1;City1;State1
Name2;2;Address2;City2;State1
Name3;3;Address3;City3;State1
Name4;4;Address4;City4;State1
```

### Example 5

See all the code for example 5 [here](src/main/java/br/com/examples/example5/Main.java)

#### Code
```java
String[] columnsName = {"Name","Age","Address","City","State"};
new CsvBuilder<Person>()
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
```
#### Response
```
Name;Age;Address;City;State
1;2;3
1;2;3;4;5
1;2;3;4;5;6
Name0;0;Address0;City0;State1
Name1;1;Address1;City1;State1
Name2;2;Address2;City2;State1
Name3;3;Address3;City3;State1
Name4;4;Address4;City4;State1
```
### Example 6

See all the code for example 6 [here](src/main/java/br/com/examples/example6/Main.java)

#### Code
```java
String[] columnsName = {"Name","Age","Address","City","State"};
new CsvBuilder<Person>()
    .forElements(people)
    .header(columnsName)
    .header(CsvBuilder.blankColumns(columnsName.length))
    .column(Person::getName)
    .column(p -> p.getAge().toString())
    .column(Person::getAddress)
    .column(Person::getCity)
    .column(Person::getState)
    .toString();
```
#### Response
```
Name;Age;Address;City;State
;;;;
Name0;0;Address0;City0;State1
Name1;1;Address1;City1;State1
Name2;2;Address2;City2;State1
Name3;3;Address3;City3;State1
Name4;4;Address4;City4;State1
```

### Example 7

See all the code for example 7 [here](src/main/java/br/com/examples/example7/Main.java)

#### Code
```java
String[] footerValues = {"footer1", "40", "some", "value", "here"};
new CsvBuilder<Person>()
    .forElements(people)
    .column(Person::getName)
    .column(p -> p.getAge().toString())
    .column(Person::getAddress)
    .column(Person::getCity)
    .column(Person::getState)
    .footer(footerValues)
    .toString();
```
#### Response
```
Name0;0;Address0;City0;State1
Name1;1;Address1;City1;State1
Name2;2;Address2;City2;State1
Name3;3;Address3;City3;State1
Name4;4;Address4;City4;State1
footer1;40;some;value;here
```

### Example 8

See all the code for example 9 [here](src/main/java/br/com/examples/example8/Main.java)

#### Code
```java
String[] footerValues = {"footer1", "40", "some", "value", "here"};
new CsvBuilder<Person>()
    .forElements(people)
    .column(Person::getName)
    .column(p -> p.getAge().toString())
    .column(Person::getAddress)
    .column(Person::getCity)
    .column(Person::getState)
    .footer(footerValues)
    .footer("another", "way", "to", "set", "footer", "values")
    .toString();
```
#### Response
```
Name0;0;Address0;City0;State1
Name1;1;Address1;City1;State1
Name2;2;Address2;City2;State1
Name3;3;Address3;City3;State1
Name4;4;Address4;City4;State1
footer1;40;some;value;here
another;way;to;set;footer;values
```

### Example 9

See all the code for example 9 [here](src/main/java/br/com/examples/example9/Main.java)

#### Code
```java
new CsvBuilder<Person>()
    .forElements(people)
    .header(CsvBuilder.rightPadding(5, "value1", "value2", "value3"))
    .header(CsvBuilder.rightPadding(5, "value1"))
    .header(CsvBuilder.rightPadding(8, "value1", "value2", "value3"))
    .column(Person::getName)
    .column(p -> p.getAge().toString())
    .column(Person::getAddress)
    .column(Person::getCity)
    .column(Person::getState)
    .toString();
```
#### Response
```
value1;value2;value3;;
value1;;;;
value1;value2;value3;;;;;
Name0;0;Address0;City0;State1
Name1;1;Address1;City1;State1
Name2;2;Address2;City2;State1
Name3;3;Address3;City3;State1
Name4;4;Address4;City4;State1
```
