package org.example.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Exercises {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(summa(list));
        //Отсортировать список строк в алфавитном порядке.
        //Найти максимальное значение в списке чисел.
        //Преобразовать список строк в список их длин.
        //Отфильтровать список объектов по определенному условию и получить только определенное количество элементов.
        //Проверить, содержит ли список хотя бы один элемент, удовлетворяющий определенному условию.
        //Группировать объекты списка по определенному критерию.
        //Найти сумму квадратов всех чисел в списке.

    }

    /*
    Найти среднее значение чисел в списке.
    List<Integer> list = Arrays.asList(1,2,3,4,5,6); //Объявление списка
     */
    public static OptionalDouble average(List<Integer> list){
        return  list.stream().mapToInt(Integer::intValue).average();

    }

    /*
    Отфильтровать список строк и получить только те, которые содержат определенную подстроку.
    newList1.forEach(System.out::println); // вывод списка
    */
    public static List<String> toContains(List<String> list,String string){
        return list.stream().filter(s -> s.contains(string)).toList();
    }
    /*
    Посчитать сумму всех четных чисел в списке.
    */
    public static int summa(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).filter(s -> s % 2 == 0).sum();
    }

    //Отсортировать список строк в алфавитном порядке.
    public static List<String> alphabetSort(List<String> list){
        return list.stream().sorted().collect(Collectors.toList());
    }
    //Найти максимальное значение в списке чисел.
    //Преобразовать список строк в список их длин.
    //Отфильтровать список объектов по определенному условию и получить только определенное количество элементов.
    //Проверить, содержит ли список хотя бы один элемент, удовлетворяющий определенному условию.
    //Группировать объекты списка по определенному критерию.
    //Найти сумму квадратов всех чисел в списке.

}

