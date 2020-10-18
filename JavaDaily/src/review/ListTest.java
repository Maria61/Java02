package review;


import java.util.ArrayList;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/23 9:00
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){this.val = val;}
}

public class ListTest {
    /**
     * 反转单链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur=  head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 从尾到头打印链表
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = listNode;
        while(cur != null){
            list.add(0,cur.val);
            cur = cur.next;
        }
        return list;
    }

    /**
     * 返回链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode pre = head;
        for(int i = 0; i < k; i++){
            if(cur == null){
                return null;
            }
            cur = cur.next;
        }
        while(cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }

    /**
     * 两个链表的第一个公共节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while(cur1 != null){
            cur1 = cur1.next;
            len1++;
        }
        while(cur2 != null){
            cur2 = cur2.next;
            len2++;
        }
        cur1 = pHead1;
        cur2 = pHead2;
        for(int i = 0; i < Math.abs(len1-len2); i++){
            if(len1 > len2){
                cur1 = cur1.next;
            }else{
                cur2 = cur2.next;
            }
        }
        while(cur1 != null){
            if(cur1 == cur2){
                return cur1;
            }else{
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return cur1;
    }

    /**
     * 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode newHead = null;
        while(cur != null){
            if(head.val != val){
                newHead = head;
            }else{
                cur = cur.next;
            }
        }
        return newHead;
    }

    /**
     * 判断链表是否有环
     * 思路：两个指针，一个走一步，一个走两步，如果存在环，两个指针一定会相遇。
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p1 != p2){
            if(p2 == null || p2.next == null){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }

    /**
     * 返回环形链表环的入口结点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;
        while(p1 != p2){
            if(p2 == null || p2.next == null){
                return null;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
