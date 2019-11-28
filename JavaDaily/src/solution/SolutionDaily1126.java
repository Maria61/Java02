package solution;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/27 23:31
 */
public class SolutionDaily1126 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] re = new boolean[n];
        for (int i = 0; i < n; i++) {
            re[i] = s.contains(p[i]);
        }
        return re;
    }

    public static String[] sort(String[] s, boolean b) {
        String[] re = new String[s.length];
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length; i++) {
            String[] s1 = s[i].split(" ");
            map.put(s1[0], Integer.valueOf(s1[1]));
        }
        return null;
    }

    public static void main1(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("acb", 12);
        map.put("sdf", 12);
        map.put("c", 13);
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + "," + m.getValue());
        }
    }

    public static void main(String[] args) {

    }

}
