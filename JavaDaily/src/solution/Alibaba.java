package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/20 8:52
 */
public class Alibaba {

    public static int method(String[] sa) {
        int re = 0;
        int index = -1;
        char minLast = '0';
        //找最小的尾
        for(int i = 0; i < sa.length; i++){
            int length = sa[i].length();
            if(i == 0){
                minLast = sa[i].charAt(length - 1);
                index = i;
            }else{
                if(minLast > sa[i].charAt(length - 1)){
                    minLast = sa[i].charAt(length - 1);
                    index = i;
                }else if(minLast == sa[i].charAt(length - 1)){
                    if(sa[index].length() < length){
                        minLast = sa[i].charAt(length - 1);
                        index = i;
                    }
                }
            }
        }
        re += sa[index].length();
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < sa.length; i++){
            if(i != index){
                arrayList.add(sa[i]);
            }
        }
        Collections.sort(arrayList);

        while(true){
            boolean flag = false;
            for(int j = index; j < arrayList.size() - 1; j++) {
                if (arrayList.get(j).charAt(0) > minLast) {
                    if (arrayList.get(j + 1).charAt(0) != arrayList.get(j).charAt(0)) {
                        int l = arrayList.get(j).length();
                        re += l;
                        index = j;
                        minLast = arrayList.get(j).charAt(l - 1);
                        flag = true;
                        break;
                    }
                }
            }
            if(flag == false){
                break;
            }
        }

        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] sa = new String[n];
        for(int i = 0; i < n; i++){
            sa[i] = sc.nextLine();
        }
        System.out.println(method(sa));
    }
}
