package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/11 15:58
 */
public class SolutionDaily0308 {

    /**
     * 木棒拼图
     * @param array
     * @return
     */
    public static String judge(ArrayList<Integer> array){
        Collections.sort(array);
        int sum = 0;
        for(int i = 0; i < array.size() - 1; i++){
            sum += array.get(i);
        }
        if(sum > array.get(array.size() - 1)){
            return "Yes";
        }else{
            return "No";
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        while(n != 0){
            String s = sc.nextLine();
            n--;
            String[] ss = s.split(" ");
            if(ss[0].equals("1")){
                arrayList.add(Integer.valueOf(ss[1]));
                System.out.println(judge(arrayList));
            }else{
                arrayList.remove(arrayList.indexOf(Integer.valueOf(ss[1])));
                System.out.println(judge(arrayList));
            }

        }
    }
}
