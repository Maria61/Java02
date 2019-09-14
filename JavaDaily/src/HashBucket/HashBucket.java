package HashBucket;

import javax.xml.soap.Node;
import java.util.*;

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

    public int get(int key) {
        int index = hashFunction(key, array.length);
        Node head = array[index];
        Node cur = head;
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }

            cur = cur.next;
        }
        return -1;
    }

    public int put(int key, int val) {
        int index = hashFunction(key, array.length);
        Node head = array[index];
        Node cur = head;
        while (cur != null) {
            if (cur.key == key) {
                int oldV = cur.val;
                cur.val = val;
                return oldV;
            }
            cur = cur.next;
        }

        Node node = new Node();
        node.val = val;
        node.key = key;
        node.next = head;

        array[index] = node;
        size++;

        if (size / array.length > 0.75) {
            resize();
        }
        return -1;
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node head = array[i];
            Node cur = head;
            while (cur != null) {
                int index = hashFunction(cur.key, newArray.length);
                Node node = new Node();
                node.key = cur.key;
                node.val = cur.val;
                node.next = newArray[index];
                newArray[index] = node;

                cur = cur.next;

            }
        }
        array = newArray;

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
                size--;
                return oldV;
            } else {
                int oldV = cur.val;
                pre.next = cur.next;
                size--;
                return oldV;
            }
        }
        return -1;
    }

    public Set<Integer> keySet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            Node head = array[i];
            Node cur = head;
            while (cur != null) {
                int key = cur.key;
                set.add(key);
                cur = cur.next;
            }
        }
        return set;
    }

    public static class Entry {
        private int key;
        private int val;
    }

    public Set<Entry> entrySet() {
        Set<Entry> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            Node head = array[i];
            Node cur = head;
            while (cur != null) {
                Entry e = new Entry();
                e.key = cur.key;
                e.val = cur.val;
                set.add(e);
                cur = cur.next;
            }
        }
        return set;
    }


    public static void main(String[] args) {
        HashBucket map = new HashBucket();
        Random random = new Random(20190912);
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(52);
//            System.out.println(random.nextInt(52));
            map.put(r, r + 10000);
        }

//        System.out.println(map.get(5));
//        System.out.println(map.get(23));
//        map.remove(23);
//        System.out.println("success");
        Set<Integer> set = map.keySet();
        System.out.println("success");
        Set<Entry> es = map.entrySet();
        System.out.println("succcess");

    }
}
