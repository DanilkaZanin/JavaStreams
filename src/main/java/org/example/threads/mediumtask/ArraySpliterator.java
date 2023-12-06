package org.example.threads.mediumtask;

import java.util.ArrayList;

/** Предназначен для разбивания массива на список подмассивов для дальнейшего многопоточного поиска */
public class ArraySpliterator{

    private final ArrayList<int[]> arrayList;
    /**
     * @param arr изначальный массив
     * @param split длина подмассива */
    public ArraySpliterator(int[] arr, int split){
        arrayList = new ArrayList<>();
        doSplit(arr,split);
    }

    public ArrayList<int[]> getArrayList() {
        return arrayList;
    }

    private void doSplit(int[] arr, int split){
        int[] newArr = new int[split];
        int j = 0;
        for(int i : arr){
            if(j < split){
                newArr[j] = i;
            } else if (j == split) {
                arrayList.add(newArr);

                newArr = new int[split];
                j = 0;
                newArr[j] = i;
            }
            j++;
        }
    }

}
