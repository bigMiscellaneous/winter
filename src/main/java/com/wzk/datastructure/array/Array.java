package com.wzk.datastructure.array;

import java.util.ArrayList;
import java.util.List;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 有参构造函数
     * @param capacity 数组的容量capacity构造Array
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的长度（容量）
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在index位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Index is illegal.");
        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size - 1 ; i >= index ; i --){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 在所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在所有元素前添加一个元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 修改制定索引位置的元素e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed.Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 获取index索引位置的元素e
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(int e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(int e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Reomve failed.Index is illegal.");
        }
        E res = data[index];
        for(int i = index  + 1 ; i < size ; i ++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(int e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    /**
     * 查找数组所有元素e的索引的集合
     * @param e
     * @return
     */
    public List<Integer> findAll(int e){
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)){
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 删除数组里所有元素e
     * @param e
     */
    public void removeAllElement(int e){
        List<Integer> list = findAll(e);
        for(int i = 0 ; i < list.size() ; i ++){
            for(int j = list.get(i) + 1 ; j < size ; j ++){
                if(list.get(i) == size - 1){
                    break;
                }
                data[j - 1] = data[j];
            }
        }
        size = size - list.size();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n",size,data.length));
        res.append("[");
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

}
