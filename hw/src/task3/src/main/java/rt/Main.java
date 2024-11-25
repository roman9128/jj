package rt;

import rt.persons.Person2;
import rt.serialization.JSONificator;

public class Main {

    public static void main(String[] args) {

        String fileName = "person";

        // Person personBeforeSerialization = new Person("Mike", 30, 1234000321l);
        // System.out.println(personBeforeSerialization);
        // SerializatorDeserializator.serializeIt(personBeforeSerialization, fileName);
        // Person personAfterDeserialization = (Person) SerializatorDeserializator.deserializeIt(fileName);
        // System.out.println(personAfterDeserialization);

        Person2 person2BeforeJSON = new Person2("Don", 30, 1122345678);
        // System.out.println(person2BeforeJSON);
        // JSONificator.writeToJSON(person2BeforeJSON, fileName);
        Person2 person2FromJSON = JSONificator.readFromJSON(Person2.class, fileName);
        System.out.println(person2FromJSON);
        


        
        
        
        
        
    }
}

/*
Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.
Задание 2: Используя JPA, создайте базу данных для хранения объектов класса Person.
Реализуйте методы для добавления, обновления и удаления объектов Person.
Однако на семинаре предложено в качестве второго задания выполнить задачу 1 с использованием других сериализаторов (в json и xml)
вместо указанного задания, что я и сделал.
*/
