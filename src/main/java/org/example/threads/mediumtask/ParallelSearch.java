package org.example.threads.mediumtask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

//Параллельный поиск: Дан массив чисел и значение, которое нужно найти.
//Реализуйте алгоритм параллельного поиска, в котором несколько потоков будут искать значение в разных фрагментах массива.
//Как только значение будет найдено, остальные потоки могут быть остановлены.
public class ParallelSearch {
    AtomicBoolean flag = new AtomicBoolean(false);

    public boolean isInArray(int[] array, int searched){
        List<Thread> threads = new ArrayList<>();
        ArraySpliterator arraySpliterator = new ArraySpliterator(array, 5);

        for(int[] i : arraySpliterator.getArrayList()){
            Thread thread = new Thread(() ->{
               find(array, searched);
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return flag.get();
    }
    private void find(int[] array, final int searched){
        for(int i : array){
            if ( i == searched){
                flag.set(true);
            }
        }
    }
}




