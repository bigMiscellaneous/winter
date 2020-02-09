package LinkedList;

public class LinkedList<E> {

    private class Node{
        public E e;
        public  Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }
        public Node(Node next){
            this(null,next);
        }

        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public LinkedList(Object[] list) {
        Node cur = head;
        for (int i = 0; i < list.length; i++) {
            cur.e = (E)list[i];
            cur = cur.next;
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;
        size ++;

        //head = new Node(e,head);
    }

    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Index is Illegal.");
        }
        if(index == 0){
            addFirst(e);
        }

        else{
            Node prev = head;
            for(int i = 0 ; i < index - 1 ; i ++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            //prev.next = new Node(e,prev.next)
            size ++;
        }
    }

    public void addLast(E e){
        add(size,e);
    }

//    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5};
//        LinkedList root = new LinkedList(array);
//    }
}
