package org.example.threads.task1;

import org.example.threads.mediumtask.ParallelSearch;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Tasks {
    volatile static int variable;
    static final Object mutex = new Object();

    public static void task1() throws InterruptedException {
        variable = 0;

        Thread thread1 =new Thread(() ->{
            synchronized (mutex){
                variable++;
            }
        });

        Thread thread2 = new Thread(() ->{
            synchronized (mutex){
                variable++;
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();



        System.out.println(variable);

    }
    //Создайте два потока, каждый из которых будет выводить свое сообщение на консоль.
    //После выполнения обоих потоков, убедитесь, что сообщения выводятся в правильном порядке.
    public static void task2() throws InterruptedException {
        Thread thread1 = new Thread(() ->{
            System.out.println("Сообщение 2");
        });
        Thread thread2 = new Thread(() ->{
            System.out.println("Сообщение 1");
        });

        thread2.start();
        thread1.start();

        thread2.join();
        thread1.join();
    }

    //Создайте несколько потоков, каждый из которых будет искать максимальный элемент в своем фрагменте массива.
    //После выполнения всех потоков, найдите максимальный элемент среди всех найденных значений.
    public static int findMax(int[] arr) throws InterruptedException {
        AtomicInteger maxOfFirthPath = new AtomicInteger();
        AtomicInteger maxOfSecondPath = new AtomicInteger();

        Thread thread1 = new Thread(() ->{
            int max1 = arr[0];

            for(int i = 1; i < arr.length / 2; i++) {
                if (max1 < arr[i])
                    max1 = arr[i];
            }
            maxOfFirthPath.set(max1);
        });
        Thread thread2 = new Thread(() ->{
            int max1 = arr[arr.length / 2];

            for(int i = arr.length / 2 + 1; i < arr.length; i++) {
                if (max1 < arr[i])
                    max1 = arr[i];
            }
            maxOfSecondPath.set(max1);
        });

        thread2.start();
        thread1.start();

        thread2.join();
        thread1.join();

        if(maxOfFirthPath.intValue() > maxOfSecondPath.intValue()){
            return maxOfFirthPath.intValue();
        }
        else{
            return maxOfSecondPath.intValue();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,10,5,6,7,8,9,11,12,13,14,15};

        ParallelSearch parallelSearch = new ParallelSearch();
        System.out.println(parallelSearch.isInArray(arr,17));
        /*System.out.println(findMax(arr));*/
    }
}
