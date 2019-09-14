package HashBucket;

import javax.xml.soap.Node;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/11 19:57
 */
public class HashBucket {
    private static class Node {
        private int key;
        private int val;
        private Node next;
    }

    private Node[] array;
    private int size;

    public HashBucket() {
        array = new Node[8];
        size = 0;
    }

    private int hashFunction(int key, int capacity) {
        return key % capacity;
    }

    public int remove(int key) {

        int index = hashFunction(key, array.length);
        Node head = array[index];
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (cur.key != key) {
                pre = cur;
                cur = cur.next;
            } else if (pre == null && cur.key == key) {
                int oldV = cur.val;
                array[index] = cur.next;
                return oldV;
            } else {
                int oldV = cur.val;
                pre.next = cur.next;
                return oldV;
            }
        }
        size--;
        return -1;
    }
}
