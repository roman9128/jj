package task2_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main1 {

    public static void main(String[] args) throws Exception {

        Class<?> personClass = Class.forName("task2_1.Person");

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Constructor[] constructors = personClass.getConstructors();

        Object persInst = constructors[0].newInstance(null);

        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(persInst, "ty");

        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(persInst, 99);

        Method declaredMethodtoString = personClass.getDeclaredMethod("toString");
        System.out.println(declaredMethodtoString.invoke(persInst, null));

    }
}
