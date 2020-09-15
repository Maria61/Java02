package solution;

import java.util.ArrayList;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/10 15:15
 */
/**
 * 一面试题
 */
public class ZhaoShang20200910 {

    /**
     * 返回和为n的所有连续子序列
     * 输入：15
     * 输出：1 2 3 4 5 ，4 5 6，7 8
     * @param n
     * @return
     */
    public static ArrayList<String> method(int n){
        ArrayList<String> list = new ArrayList<>();
        String s = "";
        for(int i = 1; i < n; i++){
            int sum = i;
            s = i+" ";
            for(int j = i + 1; j < n; j++){
                sum += j;
                s += j + " ";
                if(sum == n){
                    list.add(s);
                    sum = 0;
                    s = "";
                    break;
                }else if(sum > n){
                    sum = 0;
                    s = "";
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(method(15));
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
