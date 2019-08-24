package tree;

import java.util.ArrayList;
import java.util.Arrays;
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
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;

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

    public static int calcLeafCount(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int left = calcLeafCount(root.left);
        int right = calcLeafCount(root.right);
        return left+right;
    }

    public static Node search(Node root,char val){
        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }
        Node result = search(root.left,val);
        if(result != null){
            return result;
        }else{
            return search(root.right,val);
        }

    }

    public static boolean search1(Node root,char val){
        if(root == null){
            return false;
        }

        if(root.val == val){
            return true;
        }

        if(search1(root.left,val) != false){
            return true;
        }else{
            return search1(root.right,val);
        }


    }
    public static boolean isMirror(Node p,Node q){
        if(q == null && p == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val && isMirror(p.right,q.left)
                && isMirror(p.left,q.right);
    }

    public static Node buildTree(List<Character> inorder,List<Character> postorder){
        if(inorder.size() == 0 || postorder.size() == 0){
            return null;
        }

        char rootVal = postorder.get(postorder.size()-1);
        int rootIndex = inorder.indexOf(rootVal);
        Node root = new Node(rootVal);
        List<Character> leftInorder = inorder.subList(0,rootIndex);
        List<Character> leftPostorder = postorder.subList(0,rootIndex);
        Node left = buildTree(leftInorder,leftPostorder);
        root.left = left;
        List<Character> rightInorder = inorder.subList(rootIndex+1,inorder.size());
        List<Character> rightPostorder = postorder.subList(rootIndex,postorder.size()-2);
        Node right = buildTree(rightInorder,rightPostorder);
        root.right = right;

        return root;
    }

    public static void main(String[] args){
        Node a = createTree();

//        List<Character> list = preOrderTraversal1(a);
//        System.out.println(list);
//        System.out.println();
//        postOrderTraversal(a);
//        System.out.println();
//        inOrderTraversal(a);

//        System.out.println(calcLeafCount(a));
        System.out.println(search(a,'H'));
        System.out.println(search1(a,'H'));
        System.out.println(search1(a,'h'));
    }
}
