package rt;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataBaseMaster dbm = new DataBaseMaster(Person.class);

        List<Person> peopleList = Arrays.asList(
                new Person("Splinter", 40, "teacher"),
                new Person("Leo", 20, "tmnt"),
                new Person("Don", 20, "tmnt"),
                new Person("Raph", 20, "tmnt"),
                new Person("Mike", 20, "tmnt"));

        dbm.writeListOfObjectsToDB(peopleList);
        dbm.removeFromDB(peopleList.get(0));
        dbm.addObjectToDB(new Person("April", 30, "reporter"));
    }
}

/**
 * Задание: Настройте связь между вашим приложением и базой данных MySQL с
 * использованием Hibernate. Создайте несколько объектов Person и сохраните их в
 * базу данных.
 */
