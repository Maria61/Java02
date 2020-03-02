package algorithm_experiment;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/23 14:36
 */
class Node{
    float value;
    Node left;
    Node right;

    public Node(float value) {
        this(value,null,null);
    }

    public Node(float value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
public class Experiment1023 {

    /**
     * 顺序查找
     * @param array
     * @param n
     * @return
     */
    public static int sequenceSearch(float[] array,float n){
        for(int i = 0; i < array.length; i++){
            if(array[i] == n){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * @param array
     * @param n
     * @return
     */
    public static int binarySearch(float[] array,float n){
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(n > array[mid]){
                left = mid + 1;
            }else if( n < array[mid]){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二叉搜索树查找
     * @param array
     * @param n
     * @return
     */

    public static Boolean binaryTreeSearch(float[] array,float n){
        Node tree = create(array);
        Node cur = tree;
        while(cur != null){
            if(cur.value == n){
                return true;
            }else if(n < cur.value){
                cur = cur.left;
            }else if(n > cur.value){
                cur = cur.right;
            }
        }
        return false;
    }

    private static Node create(float[] array) {
        Node root = null;
        for(int  i = 0; i < array.length; i++){
            if(root == null){
                root = new Node(array[i]);
            }else{
                Node cur = root;
                while(cur.left != null || cur.right != null){
                    if(array[i] > cur.value){
                        cur = cur.right;
                    }else if(array[i] < cur.value){
                        cur = cur.left;
                    }
                }
                if(array[i] > cur.value){
                    Node right = new Node(array[i]);
                    cur.right = right;
                }
                if(array[i] < cur.value){
                    Node left = new Node(array[i]);
                    cur.left = left;
                }
            }
        }
        return root;
    }

    public static float[] randomNumArray(int length){
        float[] array = new float[length];
        Random random = new Random(2019);
        for(int i = 0; i < length; i++){
            array[i] = random.nextFloat();
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
    public static void main(String[] args) {
        Random random = new Random();
        float[] array = randomNumArray(20);
        int randomIndex = random.nextInt(20);
        System.out.println("查找成功的情况：");
        System.out.println("随机生成的下标是："+randomIndex+"对应的数组中的数是："+array[randomIndex]);

        //查找成功！
        int index = sequenceSearch(array,array[randomIndex]);
        System.out.println("顺序查找找到的下标是："+index+"对应的数组中的数是："+array[index]);
        index = binarySearch(array,array[randomIndex]);
        System.out.println("二分查找找到的下标是："+index+"对应的数组中的数是："+array[index]);
        boolean exist = binaryTreeSearch(array,array[randomIndex]);
        System.out.println("二叉树查找的结果是："+exist);

        //查找失败！
        System.out.println();
        System.out.println("查找失败的情况：");
        float random1 = random.nextFloat();
        System.out.println("随机数为："+random1+",找到的对应数组中的下标是："+sequenceSearch(array,random1));
        System.out.println("随机数为："+random1+",找到的对应数组中的下标是："+binarySearch(array,random1));
        System.out.println("随机数为："+random1+",找到的对应数组中的下标是："+binaryTreeSearch(array,random1));

    }
}
