package task2;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {

        Arrays.asList(String.class.getMethods()).forEach(System.out::println);

    }
}
// Используя Reflection API, напишите программу, которая выводит на экран все методы класса String