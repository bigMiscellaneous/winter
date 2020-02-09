package com.wzk.datastructure.queue;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        int count = 100000;
        LoopQueue<Integer> loop = new LoopQueue();
        ArrayQueue<Integer> array = new ArrayQueue<>();
        LinkedListQueue<Integer> list = new LinkedListQueue();
        double time1 = test(loop,count);
        double time2 = test(array,count);
        double time3 = test(list,count);
        System.out.println("LoopQueue耗时" + time1 + "s");
        System.out.println("ArrayQueue耗时" + time2 + "s");
        System.out.println("LinkedListQueue耗时" + time3 + "s");
    }

    public static double test(Queue q,int count){
        long start = System.currentTimeMillis();
        Random random = new Random();
        for(int i = 0 ; i < count ; i ++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0 ; i < count ; i ++){
            q.dequeue();
        }
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }
}
