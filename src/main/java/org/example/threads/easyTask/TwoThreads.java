package org.example.threads.easyTask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreads {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> l2 = Arrays.asList(2, 4, 6, 8, 10);
        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
           for ( int i : l1){
               lock.lock();
               lock.unlock();
               System.out.println(i);


           }
        });

        Thread thread1 = new Thread(() -> {
            for (int i : l2){
                lock.lock();
                lock.unlock();
                System.out.println(i);
            }
        });
        thread.start();
        thread1.start();
    }
}
