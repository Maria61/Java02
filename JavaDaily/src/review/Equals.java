package review;

import java.util.Objects;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/25 20:40
 */
public class Equals {
    private int a = 0;
    private String b = null;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Equals) {
            if (((Equals) obj).a == this.a && ((Equals) obj).b == this.b) {
                return true;
            }
        }

        return false;
    }

}
