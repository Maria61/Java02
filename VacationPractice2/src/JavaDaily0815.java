class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("Node(%d)",val);
    }
}
public class JavaDaily0815{
    //创建链表
    public static Node create(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        return n1;
    }
    //链表逆置
    public static Node reverse(Node head){
        Node cur = head;
        Node newList = null;
        while(cur.next != null){
            Node next = cur.next;
            cur.next = newList;
            newList = cur;
            cur = next;
        }
        return newList;
    }
    //合并两个有序链表
    public static Node merge(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        Node newLast = null;
        Node newHead = null;
        while(cur1 != null && cur2 != null){
            if(cur1.val <cur2.val){
                if(newHead == null){
                    newHead = cur1;
                }else {
                    newLast.next = cur1;

                }
                newLast = cur1;
                cur1 = cur1.next;
            }else{
                if(newHead == null){
                    newHead = cur2;
                }else {
                    newLast.next = cur2;

                }
                newLast = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null){
            newLast.next = cur1;
        }
        if(cur2 != null){
            newLast.next = cur2;
        }
        return newHead;
    }

    public static void main(String[] args){
        Node list1 = new JavaDaily0815().create();
        Node list2 = new JavaDaily0815().create();

        Node newList =merge(list1,list2);
        for(Node c = newList; c != null; c = c.next){
            System.out.println(c);//相当于 System.out.println(c.toString);
        }
    }
}