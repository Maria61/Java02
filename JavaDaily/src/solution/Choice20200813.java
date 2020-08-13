package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/8/13 23:11
 */
public class Choice20200813 {
    public class A{
        public int age;
    }

    public static void main(String[] args) {
        A[] a = new A[10];
        a[0].age = 1;
        a[1].age = 2;
        for(int i = 2; i < 10; i++){
            a[i].age = a[i - 1].age*a[i - 2].age;
        }
        System.out.println(a[9].age);
    }

}
