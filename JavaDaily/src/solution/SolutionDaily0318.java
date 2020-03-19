package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/19 14:45
 */
public class SolutionDaily0318 {
    /**
     * 数组中出现次数超过一半的数字
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        int half = array.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            map.put(array[i],map.getOrDefault(array[i],0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() >= half){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,4,2,2,2};
//        System.out.println(MoreThanHalfNum_Solution(nums));
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,3);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
        HashSet<HashMap<Integer,Integer>> set = new HashSet<>();
        set.add(map);
        set.add(map);
        for(Map<Integer,Integer> m : set){
            System.out.println(m.keySet());
        }
    }
}
