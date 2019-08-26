package tree;

import java.util.*;

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

    /**
     * 先序遍历
     * @param root
     */
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
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

    /**
     * 计算树的叶子结点的个数
     * @param root
     * @return
     */
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

    /**
     * 查找树中值为 val 的结点
     * @param root
     * @param val
     * @return
     */
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

    /**
     * 判断两颗树是否为镜像的
     * @param p
     * @param q
     * @return
     */
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

    /**
     * 通过中序遍历和后序遍历的结果推出树的结构
     * @param inorder
     * @param postorder
     * @return
     */
    public static Node buildTree(List<Character> inorder,List<Character> postorder){
        if(inorder.size() == 0 || postorder.size() == 0){
            return null;
        }

        char rootVal = postorder.get(postorder.size()-1);
        int rootIndex = inorder.indexOf(rootVal);
        Node root = new Node(rootVal);

        List<Character> leftInorder = inorder.subList(0,rootIndex);//[ )左闭右开
        List<Character> leftPostorder = postorder.subList(0,rootIndex);
        Node left = buildTree(leftInorder,leftPostorder);
        root.left = left;

        List<Character> rightInorder = inorder.subList(rootIndex+1,inorder.size());
        List<Character> rightPostorder = postorder.subList(rootIndex,postorder.size()-1);
        Node right = buildTree(rightInorder,rightPostorder);
        root.right = right;

        return root;
    }

    /**
     * 层序遍历
     * @param root 树的根节点
     */

    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }

            if (front.right != null) {
                queue.add(front.right);
            }


        }
    }

    /***
     * 判断是否是完全二叉树
     */
    public boolean isComplete(Node root){

        if(root == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //层序遍历二叉树，包含空的情况
        //弹出队首元素，如果队首元素为空则结束遍历
        while(true){
            Node front = queue.poll();
            if(front == null){
                break;
            }
            ((LinkedList<Node>) queue).add(front.left);
            ((LinkedList<Node>) queue).add(front.right);
        }
        //遍历队列其他元素是否都为空，如果都为空，说明是完全二叉树，否则是非完全二叉树
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node != null){
                return false;
            }
        }

        return true;
    }

    /**
     * 前序遍历的非递归实现
     */
    public static void preTraversal2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(!stack.empty() || cur != null){
            while(cur != null){
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            Node top = stack.pop();
            cur = top.right;
        }
    }

    /**
     * 中序遍历的非递归实现
     */
    public static void inOrderTraersal2(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            Node top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }

    /**
     * 后序遍历的非递归实现
     */
    public static void postTraesal2(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;

        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            Node top = stack.peek();
            if(top.right == null || top.right == last){
                stack.pop();
                System.out.println(top.val);
                last = top;
            }else{
                cur = top.right;
            }
        }
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
