package LinkedList;

public class LinkedListDummyHead<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListDummyHead() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index,E e){
        if(index <  0 || index > size){
            throw new IllegalArgumentException("Add failed.Index is illegal.");
        }
        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

}