package task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 12);

        System.out.println("Чётные числа из списка: " + list.stream().filter(n -> (n % 2 == 0)).toList());
        System.out.println("Среднее значение всех чётных чисел в списке: " + list.stream().filter(n -> (n % 2 == 0)).collect(Collectors.averagingInt(Integer::intValue)));

    }

}

/*
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
