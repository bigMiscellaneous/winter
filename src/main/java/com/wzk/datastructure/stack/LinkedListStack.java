package com.wzk.datastructure.stack;

import com.wzk.datastructure.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList();
    }

    @Override
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E pop(){
        return list.removeFirst();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public E peek(){
        return list.getFirst();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LinkedListStack :");
        res.append(" top :");
//        for(int i = 0 ; i < list.getSize() ; i ++){
//            res.append(list.get(i));
//            if(i != list.getSize() - 1){
//                res.append(",");
//            }
//        }
//        res.append("]");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> list = new LinkedListStack<>();
        for(int i = 0 ; i < 5 ; i ++){
            list.push(i);
            System.out.println(list);
        }
        list.pop();
        System.out.println(list);
    }
}
