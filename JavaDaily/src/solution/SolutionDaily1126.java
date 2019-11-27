package solution;

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
        for (int i = 0; i < s.length; i++) {
            String[] s1 = s[i].split(" ");
            for (int j = 0; j < re.length; j++) {
                if (s1[1] < re[])
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
