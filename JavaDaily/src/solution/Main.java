package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/11 17:22
 */
//public class Main {
//    /**
//     * 牛客刷题输入输出练习
//     */
//    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        while (sc.hasNextInt()) {
////            int a = sc.nextInt();
////            int b = sc.nextInt();
////            System.out.println(a + b);
////        }
//
////        Scanner sc = new Scanner(System.in);
////        while(sc.hasNextLine()){
////            int sum = 0;
////            String[] s = sc.nextLine().split(" ");
////            for(int j = 0; j < s.length; j ++){
////                sum = sum + Integer.parseInt(s[j]);
////            }
////            System.out.println(sum);
////        }
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] s = new String[100];//?
//        int i = 0;
//        while (i < n) {
//            s[i] = sc.next();
//            i++;
//        }
//
//        for (i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 2; j++) {
//                if (Integer.valueOf(s[j]) > Integer.valueOf(s[j + 1])) {
//                    String temp = s[j];
//                    s[j] = s[j + 1];
//                    s[j + 1] = temp;
//                }
//            }
//        }
//        for (i = 0; i < n; i++) {
//            System.out.println(s[i]);
//        }
//
//    }
//}

//javaSE测试编程题2
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map m = new HashMap<Integer, String>();
        while (sc.hasNextLine()) {
            int i = 0;
            String s = sc.nextLine();
            m.put(i, s);
            if (i >= 50)
                break;
            if (s.equals(" ")) {
                break;
            }
            i++;
            System.out.println(s);
        }
        System.out.println(m.size());
        Set set = new HashSet<String>();
        for (int i = 0; i < m.size(); i++) {
            String s1 = (String) m.get(i);
            String[] s2 = s1.split(" ");
            for (String st : s2) {
                System.out.println(st);
                set.add(st);
            }
        }
        System.out.println(set.size());
    }
}
//javaSE测试编程题1
//public class Main{
//    static int fab(int i){
////        if(i == 0){
////            return 0;
////        }
////        if(i == 1){
////            return 1;
////        }
////
////        return fab(i-1)+fab(i-2);
//        int a = 0;
//        int b = 1;
//        int c = a + b;
//        if (i == 0) {
//            return 0;
//        }
//        for(int j = 0; j < i - 1; j++){
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return c;
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int i = 0;
//        int f = 1;
//        while(fab(i) <= n ){
//
//            if(fab(i) == n){
//                f = 0;
//                break;
//            }
//            i++;
//
//        }
//        if(f == 0){
//            System.out.println(0);
//        }else{
//            if((fab(i) - n) >  n-fab(i - 1)){
//                System.out.println(n - fab(i -1));
//            }else{
//                System.out.println(fab(i) - n);
//            }
//
//        }
//
//        System.out.println(fab(i - 1));
//    }
//}
