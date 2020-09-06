package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/5 9:02
 */
public class SolutionDaily20200905 {
    /**
     * 找出旋转数组的最小数
     * 旋转数组：将非递减数组的前n个元素搬移到数组的末尾
     * eg:{2,3,4,1},{4,5,6,7,2,3,4}
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int i = array.length/2;
        while(i >= 1 && i <= array.length - 1){
            if(array[i] > array[i+1]){
                i++;
            }else if(array[i] <= array[i + 1] && array[i] >= array[i-1]){
                i--;
            }else{
                break;
            }
        }
        return array[i];
    }

    /**
     * 二分查找
     * @param arr
     * @param n
     */
    public static int BinarySearch(int[] arr,int n){
        int left = 0;
        int right = arr.length - 1;
        int re = -1;
        while(left <= right){
            int mid = right -(right - left)/2;
            if(arr[mid] > n){
                right = mid - 1;
            }else if(arr[mid] < n){
                left = mid + 1;
            }else{
                re = mid;
            }
        }
        return re;
    }
    public static void main(String[] args) {
        int[] array = {4,6};
        System.out.println(minNumberInRotateArray(array));
    }
}
