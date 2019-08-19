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

        public Node(int val,Node pre,Node next){
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
        if(index < 0 || index > size){
            System.out.println("参数不合法");
            return false;
        }

        if(index == 0){
            head = new Node(element,null,head);
            if(head.next != null){
                head.next.pre = head;
            }
            size++;
            return true;
        }

        if(index == size){
            last = new Node(element,last,null);
            if(last.pre !=null){
                last.pre.next = last;
            }
            size++;
            return true;
        }

        Node node = getNode(index);
        Node newNode = new Node(element,node.pre,node);
        node.pre.next = newNode;
        node.pre = newNode;
        size++;

        return true;
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
