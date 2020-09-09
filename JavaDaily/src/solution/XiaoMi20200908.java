package solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/8 18:33
 */
public class XiaoMi20200908 {
    /**
     * 扑克牌排序（2比A大，A比K大）
     * @param pokers
     * @return
     */
    static String[] pokersort(String[] pokers) {
        String[] re = new String[pokers.length];
//        LinkedList<ArrayList<String>> lists = new LinkedList<>();
//        for(int i = 0; i < pokers.length; i++){
//            if(pokers[i].equals("J")){
//                lists.get(11).add(pokers[i]);
//            }else if(pokers[i].equals("Q")){
//                lists.get(12).add(pokers[i]);
//            }else if(pokers[i].equals("K")){
//                lists.get(13).add(pokers[i]);
//            }else if(pokers[i].equals("A")){
//                lists.get(1).add(pokers[i]);
//            }else{
//                lists.get(Integer.valueOf(pokers[i])).add(pokers[i]);
//            }
//        }
//        for(int i = 3; i < lists.size(); i++){
//            if(lists.get(i) != null){
//
//            }
////            re[i] =
//        }
        Arrays.sort(pokers);
        ArrayList<String> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < pokers.length; i++){
            if(pokers[i].equals("J") || pokers[i].equals("Q")
                    || pokers[i].equals("K") || pokers[i].equals("A")
                    || pokers[i].equals("2") || pokers[i].equals("10")){
                list.add(pokers[i]);
            }else {
                re[j] = pokers[i];
                j++;
            }
        }
        int[] arr = new int[6];
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("10")){
                arr[0] += 1;
            }else if(list.get(i).equals("J")){
                arr[1] += 1;
            }else if(list.get(i).equals("Q")){
                arr[2] += 1;
            }else if(list.get(i).equals("K")){
                arr[3] += 1;
            }else if(list.get(i).equals("A")){
                arr[4] += 1;
            }else if(list.get(i).equals("2")){
                arr[5] += 1;
            }
        }
        String[] s = {"10","J","Q","K","A","2"};
        for(int i = 0; i < 6; i++){
            for(int k = 0; k < arr[i]; k++){
                re[j] = s[i];
                j++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
//        String[] s = {"4","3","6","5","Q","J","K"};
//        Arrays.sort(s);
//        System.out.println(Arrays.toString(s));
//        String[][] ss = new String[2][];
//        ss[1][0] = "asd";
//        ss[1][2] = "asdd";
//        ss[1][3] = "asddd";
//        ss[0][0] = "qwe";
//        ss[0][1] = "qwer";
//        System.out.println(Arrays.toString(ss));
//        ArrayList<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("A");
//        list.add("A");
//        System.out.println(list.contains("A"));
//        System.out.println(list.indexOf("A"));
//
//        System.out.println(Arrays.toString(list.toArray()));
//        String[] s = {"2","3","4","K","J","9","A","A","10"};
        String[] s = {"2","3","A"};
        System.out.println(Arrays.toString(pokersort(s)));


    }
}
