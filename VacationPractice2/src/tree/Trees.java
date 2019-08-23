package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-23 10:45
 */

public class Trees {

    public static Node createTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;

        return a;
    }
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }
    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);

    }


    public static List<Character> preOrderTraversal1(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Character> list = new ArrayList<>();
        list.add(root.val);
        List<Character> listL = preOrderTraversal1(root.left);
        List<Character> listR = preOrderTraversal1(root.right);
        list.addAll(listL);
        list.addAll(listR);
        return list;

    }

    public static void main(String[] args){
        Node a = createTree();
        List<Character> list = preOrderTraversal1(a);
        System.out.println(list);
        System.out.println();
        postOrderTraversal(a);
        System.out.println();
        inOrderTraversal(a);
    }
}
