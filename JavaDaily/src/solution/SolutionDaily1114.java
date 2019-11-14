package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/14 22:49
 */
public class SolutionDaily1114 {
    String str = new String("hello");
    char[] c = {'a', 'b'};

    private static void method() {
        System.out.println("-----");
    }

    public void method(String str, char c[]) {
//        str = "test";
        str = new String("test");
        c[0] = 'c';
    }

    public static void main(String[] args) {
//        int i = 0;
//        Integer j = new Integer(0);
//        System.out.println(i==j);
//        System.out.println(j.equals(i));

//        ((SolutionDaily1114)null).method();
//
//        String s = "fmn";
//        String x = s.toUpperCase();
//        String y = s.replace('f','F');
//        y = y + "wxy";
//        System.out.println(y);
//        System.out.println(x);

        SolutionDaily1114 solutionDaily1114 = new SolutionDaily1114();
        solutionDaily1114.method(solutionDaily1114.str, solutionDaily1114.c);
        System.out.println(solutionDaily1114.c);
        System.out.println(solutionDaily1114.str);

    }
}
