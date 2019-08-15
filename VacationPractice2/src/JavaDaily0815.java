class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }
}
public class JavaDaily0815{
    //链表逆置
    public Node reverse(Node head){
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
    //表现多态的数组类型的引用

    public static void main(String[] args){

    }
}