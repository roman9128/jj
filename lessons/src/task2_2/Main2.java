package task2_2;

import java.lang.reflect.Field;

public class Main2 {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Car car = new Car("Zhigool", "black", 1999);
        showFieldValues(car);
    }

    private static <T> void showFieldValues(T object) throws IllegalArgumentException, IllegalAccessException {
        Class<?> objClass = object.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + ": " + field.get(object));
        }
    }
}