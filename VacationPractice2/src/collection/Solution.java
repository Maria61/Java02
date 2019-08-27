package collection;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //杨辉三角（LeetCode 118）
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> list = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++){
            List<Integer> list1 = new ArrayList<>();
            list.add(list1);
        }
        if(numRows == 1){
            list.get(0).add(1);
        }
        if(numRows > 1){
            list.get(0).add(1);
            list.get(1).add(1);
            list.get(1).add(1);
        }

        for(int i = 2; i < numRows; i++){
            List<Integer> list1 = new ArrayList<>(i+1);
            list1.add(1);
            for(int j = 1; j < i; j++){
                list1.add(j,list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }
            list1.add(1);

            list.set(i,list1);

        }

        return list;
    }

    public static void main(String[] args){
        System.out.println(generate(0));
    }
}
