package task2;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {

        Arrays.asList(String.class.getMethods()).forEach(m -> System.out.println(m));

    }
}
// Используя Reflection API, напишите программу, которая выводит на экран все методы класса String