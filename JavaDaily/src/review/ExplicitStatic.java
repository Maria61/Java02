package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/7 20:36
 */
class Cup {

    Cup(int x) {
        System.out.println("Cup(" + x + ")");
    }

    void f(int x) {
        System.out.println("f(" + x + ")");
    }
}


class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside");
        Cups.cup1.f(99);
    }
}
