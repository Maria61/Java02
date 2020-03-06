package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/6 20:12
 */
public class SolutionDaily0305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,Integer> map = new HashMap<>();
        int z = 0;
        for(char c = '0';c <='9'; c++){
            map.put(c,z++);
        }
        for(char c = 'A'; c < 'F' ; c++){
            map.put(c,z++);
        }

        while(sc.hasNext()){
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            int rei = 0;
            for(int i = c.length - 1,j = 0; i > 1; i--){
                rei += map.get(c[i])*Math.pow(16,j++);
            }
            System.out.println(String.valueOf(rei));
        }
    }
}
