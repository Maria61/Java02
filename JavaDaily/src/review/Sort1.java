package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/5/21 21:55
 */
public class Sort1 {
    /**
     * 冒泡：
     * 通过两两比较，将大的那一个向后移动，
     * 已经被移动到后面的则不需要再进行比较，即第二层循环次数为array.length - i的原因
     */
    public static void bubbleSort(int[] array){
        boolean flag = false;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if(flag = false){
                break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
