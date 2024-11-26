package rt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import rt.persons.Person;
import rt.persons.Person2;
import rt.serialization.JSONificator;
import rt.serialization.SerializatorDeserializator;
import rt.serialization.XMLficator;

public class Main {

    public static void main(String[] args) {

        String fileName = "person";

        Person person = new Person("Mike", 30, 1234000321l);
        Person2 person2 = new Person2("Don", 30, 1122345678);
        List<Person2> personsList = Arrays.asList(
                new Person2("Raph", 30, 1345678901),
                new Person2("Leo", 30, 1456789012));

        SerializatorDeserializator.serializeIt(person, fileName);
        Person personAfterDeserialization = SerializatorDeserializator.deserializeIt(Person.class, fileName);

        XMLficator.writeToXML(person2, fileName);
        Person2 person2fromXML = XMLficator.readFromXML(Person2.class, fileName);

        JSONificator.writeToJSON(person2, fileName);
        Person2 person2FromJSON = JSONificator.readFromJSON(Person2.class, fileName);

        XMLficator.writeToXML(personsList, fileName + "list");
        List<Person2> person2ListFromXML = XMLficator.readFromXML(List.class, Person2.class, fileName + "list");

        JSONificator.writeToJSON(personsList, fileName + "list");
        HashSet<Person2> person2SetFromJSON = JSONificator.readFromJSON(HashSet.class, Person2.class, fileName + "list");
    }
}

/*
Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.
Задание 2: Используя JPA, создайте базу данных для хранения объектов класса Person.
Реализуйте методы для добавления, обновления и удаления объектов Person.
Однако на семинаре предложено в качестве второго задания выполнить задачу 1 с использованием других сериализаторов (в json и xml)
вместо указанного задания, что я и сделал.
 */
