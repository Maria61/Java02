package BinarySearchTree;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/8 20:48
 */

/**
 * 通过平衡二叉树实现 Map
 */
public class BinarySearchTree {
    private static class Node{
        int key;
        int value;

        Node left;
        Node right;
    }

    private Node root = null;

    /**
     * 查找
     * @param key 关键字
     * @return 找到了返回对应的value,否则返回-1
     */
    public int get(int key){
        Node cur = root;
        while(cur != null){
            if(root.key == key){
                return cur.value;
            }else if(key > cur.left.key){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return -1;
    }


    /**
     * 插入(更新)
     * @param key  对应的键
     * @param value 对应的值
     * @return  如果key原本存在，插入成功后返回key原来对应的值，如果不存在，插入成功后返回-1
     */

    public int put(int key, int value){
        if(root == null){
            Node node = new Node();
            node.key = key;
            node.value = value;
            root = node;
            return -1;
        }

        Node parent = null;
        Node cur = root;
        while(cur != null){
            if(key == cur.key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        Node node = new Node();
        node.key = key;
        node.value = value;
        if(key < parent.key){
            parent.left = node;
        }else{
            parent.right = node;
        }

        return -1;
    }

    /**
     * 查找
     * @param key 查找的关键字
     * @param defaultValue 如果没找到，返回的默认值
     * @return 找到了，返回对应的value,如果没找到，返回参数defalueValue
     */
    public int getOrDefault(int key, int defaultValue){
        Node cur = root;
        while(cur != null){
            if(cur.key == key){
                return cur.value;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return defaultValue;
    }

    /**
     * 查找Map中所有的key
     *
     * @return 以set的形式返回所有的 key
     */

    public Set<Integer> keySet(){
        Set<Integer> result = new HashSet<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.poll();
            result.add(front.key);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }

        return result;
    }

    public static class Entry {
        private int key;
        private int val;

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }
    }

    /**
     * 用搜索树实现entrySet,遍历map
     *
     * @return 返回map中所有的键值对，用set存放
     */

    public Set<Entry> entrySet() {
        Set<Entry> set = new HashSet<>();
        if (root == null) {
            return set;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            Entry e = new Entry();
            e.key = front.key;
            e.val = front.value;
            set.add(e);

            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }

        }

        return set;
    }

}

