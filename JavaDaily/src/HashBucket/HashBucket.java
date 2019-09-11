package HashBucket;

import javax.xml.soap.Node;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/11 19:57
 */
public class HashBucket {
    public int remove(int key) {
        int index = hashFunction(key);
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
