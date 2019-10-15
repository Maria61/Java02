package review;

public class ExceptionDemo {
    public static int haha() {

        int i = 10;

        try {

            return i++; //i++: 10 i:11

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            i++; // i:12  （debug后发现，执行完该句之后，又跳回了try语句块，返回try语句块的返回值）

        }
        return i;
    }

    public static int hahaha() {

        int i = 10;

        try {

            return i++; //i++: 10 i:11


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            return i++;//i++:11, i:12   （debug后发现：直接在此处跳出）

        }
    }

    public static void main(String[] args) {
        /**
         * 总结来说：当finally中有return时，直接return，
         *          如果finally没有return，在try里返回，如果try也没有return,再考虑最外层的return
         *          感觉有优先级的限制，理解不深刻，不知道理解的对不对，还请庞大佬赐教 😂😂
         */
        System.out.println(haha());//10
        System.out.println(hahaha());//11
    }
}
