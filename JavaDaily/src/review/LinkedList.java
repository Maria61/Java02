package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/23 20:54
 */
class Node {
    int value;
    Node next;
    Node pre;

    public Node(int value, Node next, Node pre) {
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    public Node(int value) {
        this.value = value;
    }
}

public class LinkedList {

    Node first = null;
    Node last = null;

    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = first;
        if (first != null) {
            first.pre = node;
            node.next = first;
        } else {
            last = node;
        }
        first = node;

    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (first == null) {
            addFirst(value);
        } else {
            last.next = node;
            node.pre = last;
            last = node;
        }

    }

    public int pollFirst() throws Exception {
        if (first == null) {
            throw new Exception("链表为空");
        } else {
            int oldV = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            } else {
                first.pre = null;
            }
            return oldV;
        }
    }

    public int pollLast() throws Exception {
        if (last == null) {
            throw new Exception("链表为空");
        } else {
            int oldV = last.value;
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
            return oldV;
        }
    }

    public static void main(String[] args) {

    }
}
