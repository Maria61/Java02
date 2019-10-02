package review;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/27 18:55
 */
enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumDemo {
    public static void main(String[] args) {
        Week w = Week.MONDAY;
        System.out.println(w);
        System.out.println(Arrays.toString(Week.values()));
    }

}
