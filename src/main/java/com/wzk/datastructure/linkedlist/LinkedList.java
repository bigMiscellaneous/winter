package com.wzk.datastructure.linkedlist;

public class LinkedList<E> {

    private class Node{

        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在链表的index位置添加新的元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Index is illegal.");
        }
        Node node = dummyHead;
        Node cur = new Node(e);
        for(int i = 0 ; i < index ; i ++){
            node = node.next;
        }
        cur.next = node.next;
        node.next = cur;
        
        size ++;
    }

    /**链表末尾添加新的元素e
     * 在
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的第index个位置的元素
     * 在链表中不是一个常用的操作
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        Node node = dummyHead.next;
        for(int i = 0 ; i < index ; i ++){
            node = node.next;
        }
        return node.e;
    }

    /**
     * 获得链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素e
     * 在链表中不是一个常用的操作
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed.Index is illegal.");
        }
        Node node = dummyHead.next;
        for(int i = 0 ; i < index ; i ++){
            node = node.next;
        }
        node.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node node = dummyHead.next;
        while(node != null){
            if(node.e == e){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 从链表中删除index位置的元素，返回删除的元素
     * 在链表中不是常用的操作
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed.Index is illegal.");
        }
        Node node = dummyHead;
        for(int i = 0 ; i < index ; i ++){
            node = node.next;
        }
        Node delNode = node.next;
        E res = delNode.e;
        node.next = delNode.next;
        delNode.next = null;
        size --;
        return res;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node node = dummyHead.next;
        while(node != null){
            res.append(node + "->");
            node = node.next;
        }
        //for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        for(int i = 0 ; i < 5 ; i ++){
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(2,666);
        System.out.println(list);
        list.addFirst(-1);
        System.out.println(list);
        list.addLast(8888);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
    }
}
