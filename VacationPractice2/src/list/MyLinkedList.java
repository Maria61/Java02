package list;

public class MyLinkedList implements List{
    private static class Node{
        private int val;
        private Node next;
        private Node pre;

        public Node(int val){
            this.val = val;
            this.pre = null;
            this.next = null;
        }

        public Node(int val,Node next,Node pre){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }
    private Node head = null;
    private Node last = null;
    private int size;

    private Node getNode(int index){
        int i = 0;
        Node cur = head;
        if(index < size/2){
            while(i < index){
                cur = cur.next;
                i++;
            }
            return cur;
        }else{
            cur = last;
            i = size-1;
            while(i > size-index-1){
                cur = cur.pre;
            }
            return cur;
        }
    }

    @Override
    public boolean add(int element) {


        return false;
    }

    @Override
    public boolean add(int index, int element) {

        return false;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int set(int index, int val) {
        return 0;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
