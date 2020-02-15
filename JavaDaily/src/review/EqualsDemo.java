package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/25 20:40
 */
public class EqualsDemo {
    private int a = 0;
    private String b = null;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof EqualsDemo) {
            if (((EqualsDemo) obj).a == this.a && ((EqualsDemo) obj).b == this.b) {
                return true;
            }
        }

        return false;
    }

}
