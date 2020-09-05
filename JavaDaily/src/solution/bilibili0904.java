package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/4 19:49
 */
public class bilibili0904 {
    /**
     * 找到2个孩子的糖果数之和等于指定值
     * @param candiesNeed int整型 2个孩子的糖果数之和
     * @param candies int整型一维数组 每个孩子的糖果数
     * @return int整型一维数组
     */
    public static int[] find_children (int candiesNeed, int[] candies) {
        // write code here
        int[] re = {-1,-1};
        for(int i = 0; i < candies.length; i++){
            int k = candiesNeed - candies[i];
            for(int j = i + 1; j < candies.length; j++){
                if(candies[j] == k){
                    int min = Math.min(i,j);
                    int max = Math.max(i,j);
                    if(re[0] != -1){
                        if(re[0] > min){
                            re[0] = min;
                            re[1] = max;
                        }
                    }else{
                        re[0] = min;
                        re[1] = max;
                    }
                }
            }
        }
        return re;
    }

    /**
     * 输出菱形
     * @param n int整型 行数&列数
     * @return string字符串
     * "**1**|*121*|12321|*121*|**1**"
     * @return
     */
    public static String print_diamond (int n) {
        // write code here
        if(n % 2 ==0){
            return "";
        }
        String re = new String();
        String[] arr = new String[n];
        for(int i = 0; i <= n/2; i++){
            arr[i] = "";
            for(int j = 0; j < n/2 - i; j++){
                arr[i] += "*";
            }
            for(int j =0; j <= i; j++){
                arr[i] += j+1;
            }
            String s = new String();
            s = "";
            for(int k = arr[i].length() - 2; k >= 0; k--){
                s+=arr[i].charAt(k);
            }
            arr[i] += s;
        }
        for(int i = arr.length - 1; i > n/2; i-- ){
            arr[i] = arr[arr.length - i - 1];
        }
        for(int i = 0; i < arr.length; i++) {
            re += arr[i];
            if( i != arr.length - 1){
                re += "|";
            }
        }
        System.out.println(re);
        return re;
    }

    public static void main(String[] args) {
//        int[] arr = {2,3,4,3};
//        System.out.println(Arrays.toString(find_children(1,arr)));
        print_diamond(7);
    }
}
