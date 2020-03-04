package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/4 19:29
 */
public class SolutionDaily0303 {
    public static int change(String a){
        if(a.equals("B")){
            return 3;
        }else if(a.equals("C")){
            return 2;
        }else if(a.equals("J")){
            return 1;
        }
        return -2;
    }

    public static void judge(String input,int[] a,int[] b,HashMap<String,Integer> wa,HashMap<String,Integer> wb){
        String[] in = input.split(" ");
        if(in[0].equals(in[1])){
            a[1] = a[1] + 1;
            b[1] = b[1] + 1;
        }else if(Math.abs(change(in[0]) - change(in[1]))== 2){
            if(in[0].equals("B")){
                a[2] += 1;
                b[0] += 1;
                if(wb.containsKey(in[1])){
                    wb.replace(in[1],wb.get(in[1])+1);
                }else{
                    wb.put(in[1],1);
                }
            }else{
                a[0] += 1;
                b[2] += 1;
                if(wa.containsKey(in[0])){
                    wa.replace(in[0],wa.get(in[0])+1);
                }else{
                    wa.put(in[0],1);
                }
            }
        }else{
            if(change(in[0]) > change(in[1])){
                a[0] += 1;
                b[2] += 1;
                if(wa.containsKey(in[0])){
                    wa.replace(in[0],wa.get(in[0])+1);
                }else{
                    wa.put(in[0],1);
                }
            }else{
                a[2] += 1;
                b[0] += 1;
                if(wb.containsKey(in[1])){
                    wb.replace(in[1],wb.get(in[1])+1);
                }else{
                    wb.put(in[1],1);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];//甲：存放胜，平，负的结果
        int[] b = new int[3];//乙：
//        System.out.println(Arrays.toString(a));
        HashMap<String,Integer> wa = new HashMap<>();//甲：存放赢的手势分别的次数,B,C,J
        HashMap<String,Integer> wb = new HashMap<>();//乙：
        int sum = sc.nextInt();
        sc.nextLine();
        while(sum != 0){
            String input = sc.nextLine();
            judge(input,a,b,wa,wb);
            sum--;
        }
        StringBuilder rea = new StringBuilder();
        StringBuilder reb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            rea.append(a[i]+" ");
            reb.append(b[i]+" ");
        }
        rea = rea.delete(rea.length() - 1,rea.length());
        reb = reb.delete(reb.length() - 1,reb.length());
        String ra = null;
        String rb = null;
        int max = -1;
        for(Map.Entry<String,Integer> m : wa.entrySet()){
            if(m.getValue() > max){
                max = m.getValue();
                ra = m.getKey();
            }
        }
        max = -1;
        for(Map.Entry<String,Integer> m : wb.entrySet()){
            if(m.getValue() > max){
                max = m.getValue();
                rb = m.getKey();
            }
        }
        String rew = ra+" "+rb;
        System.out.println(rea);
        System.out.println(reb);
        System.out.println(rew);

    }


}
