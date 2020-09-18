package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/18 18:45
 */
public class ZiJieTiaoDong20200918 {
    /**
     *
     * @param arr
     * @return
     */
    public static int method(int[] arr){
        if(arr.length <= 1){
            return 0;
        }
        int re = arr[1] - arr[0];
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                re = Math.max(re,arr[j] - arr[i]);
            }
        }

        return re;
    }
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
    }

}
