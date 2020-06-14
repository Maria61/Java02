package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/6/14 11:09
 */
class LinkedList{
    int value;
    LinkedList next;

    public LinkedList(int value){
        this.value = value;
    }

}
public class Solution0614 {
    /**
     * 判断一个链表是否是循环链表（首尾相应的）
     */
    public static boolean judgeCircle(LinkedList head){
        if(head == null){
            return false;
        }
        LinkedList next = head;
        while(next != null){
            next = next.next;
            if(next == head){//某个结点的next如果等于head，则有循环
                return true;
            }
        }
        return false;
    }
    /**
     * 判断一个链表是否有环（包含但不限于上一种情况）
     */
    public static boolean judgeCircle2(LinkedList head){
        if(head == null){
            return false;
        }
        LinkedList slow = head;//每次只走一格
        LinkedList fast = head;//每次走两格
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){//快的与慢的相遇，则说明有环
                return true;
            }
        }
        return false;
    }
    /**
     * 反转单链表
     * 三指针法：
     * 一个指针指向当前结点，一个指向下一个结点（提前保存），一个指向当前节点修改后的next
     * 三个指针遍历前移即可
     */
    public static LinkedList reverse(LinkedList head){
        LinkedList pre = null;
        LinkedList next = null;
        LinkedList node = head;
        while(node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static LinkedList reverse1(LinkedList head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedList newHead = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 用栈实现队列
     */


    /**
     * 找出一组整数中重复的数
     */
    public static int[] findRepeat(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                set1.add(arr[i]);
            }else{
                set.add(arr[i]);
            }
        }
        int[] re = new int[set1.size()];
        int i = 0;
        for(Integer e : set1){
            re[i] = e;
            i++;
        }
        return re;
    }
    /**
     * 给你一些键值对，按键的顺序排序输出
     */
    public static void sortKV(HashMap map){

    }

    //测试判断是否有循环链表（首尾相连的）
    public static void test1(){
        LinkedList head = new LinkedList(1);
        LinkedList l2 = new LinkedList(2);
        LinkedList l3 = new LinkedList(3);
        LinkedList l4 = new LinkedList(4);
        LinkedList l5 = new LinkedList(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = head;
        System.out.println(judgeCircle(head));
    }
    //测试判断是否有环
    public static void test2(){
        LinkedList head = new LinkedList(1);
        LinkedList l2 = new LinkedList(2);
        LinkedList l3 = new LinkedList(3);
        LinkedList l4 = new LinkedList(4);
        LinkedList l5 = new LinkedList(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;
        System.out.println(judgeCircle2(head));
    }
    //测试反转单链表
    public static void test3(){
        LinkedList head = new LinkedList(1);
        LinkedList l2 = new LinkedList(2);
        LinkedList l3 = new LinkedList(3);
        LinkedList l4 = new LinkedList(4);
        LinkedList l5 = new LinkedList(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        LinkedList cur = head;
        while(cur != null){
            System.out.print(cur.value+"->");
            cur = cur.next;
        }
        System.out.println();
        cur = reverse1(head);
        while(cur != null){
            System.out.print(cur.value+"->");
            cur = cur.next;
        }
    }
    //测试查找数组中重复的数
    public static void test4(){
        int[] arr = {1,2,3,4,2,6,5,3,7,3,2,7,1,9,0};
        System.out.println(Arrays.toString(findRepeat(arr)));
    }

    public static void main(String[] args) {
        test4();
    }
}
