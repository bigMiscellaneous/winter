package sort;

import java.util.Random;

public class SortHelpTest<E> {

    public int[] generateRandomArray(int n,int left,int right){
        int[] array = new int[n];
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < array.length ; i ++){
            array[i] = new Random().nextInt(right - left + 1)  + left;
        }
        long end = System.currentTimeMillis();
        return array;
    }

    public void printArray(E[] array){
        for(int i = 0 ; i < array.length ; i ++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
