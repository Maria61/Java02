package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/28 9:15
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class SolutionDaily1127 {
    public static int getValue(int[] gifts, int n) {
        int[] re = new int[100];
        for (int i = 0; i < gifts.length; i++) {
            re[gifts[i]]++;
        }
        for (int i = 0; i < re.length; i++) {
            if (re[i] > (n / 2)) {
                return i;
            }
        }
        return 0;
    }

    public static int getValue2(int[] gifts, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < gifts.length; i++) {
            if (map.containsKey(gifts[i])) {
                int v = map.get(gifts[i]);
                map.put(gifts[i], ++v);
            } else {
                map.put(gifts[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > (n / 2)) {
                return e.getKey();
            }
        }
        return 0;
    }

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode cur = pHead;
        ListNode s = null;
        ListNode sLast = null;
        ListNode b = null;
        ListNode bLast = null;

        while (cur != null) {
            if (cur.val < x) {
                if (s == null) {
                    s = cur;
                } else {
                    sLast.next = cur;
                }
                sLast = cur;
            } else {
                if (b == null) {
                    b = cur;
                } else {
                    bLast.next = cur;
                }
                bLast = cur;
            }
            cur = cur.next;
        }
        if (bLast != null) {
            bLast.next = null;
        }
        if (s != null) {
            sLast.next = b;
        } else {
            return b;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 2};
        System.out.println(getValue2(array, array.length));
    }
}
