package stackandqueue;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @date 2019-08-21 10:22
 */
class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}
public class Queue {
    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public void push(int x){
        size++;
        if(rear != null){
            rear.next = new Node(x);
            rear = rear.next;
        }else{
            front = rear = new Node(x);
        }

    }

    public int pop(){
        int v = front.val;
        size--;
        front = front.next;
        if(front == null){
            rear = null;
        }

        return v;
    }

    public int rear(){
        return rear.val;
    }

    public int front(){
        return front.val;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
