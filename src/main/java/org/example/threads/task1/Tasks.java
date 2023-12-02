package org.example.threads.task1;

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


    public static void main(String[] args) throws InterruptedException {
        task2();
    }
}
