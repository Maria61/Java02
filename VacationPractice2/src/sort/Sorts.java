package sort;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-28 9:57
 */
public class Sorts {
    private static void insertSortV1(int[] array){
        for(int i = 0; i < array.length; i++){
            int key = array[i+1];
            int j = 0;
            for(j = i; j >= 0; j--){
                if(key >= array[j]){
                    break;
                }
            }
            for(int k = i; k > j; k--){
                array[k+1] = array[k];
            }

        }

    }
    private static void insertSortV2(int[] array){
        /**
         * 默认下标为0的位置已经有序
         * 有序区间为[0,i]
         * 无序区间为[i+1,array.length-1]
         *
         * 每次取无序区间的第一个数key 与 有序区间的最后一个数 array[i] 比较
         *      1）如果 key >= array[i],即已经有序，无序交换位置
         *      2）否则 将比较的有序期间向后搬移一位，key 继续和 有序区间倒序比较，
         *      3）跳出条件：1）key > 有序区间的某一个数，记住下标
         *                 2）有序区间已经被遍历完了，下标为 -1，key依然 < 有序区间的数，
         *      4）最后将key插入到该下标的下一个位置
         *
         */

        for(int i = 0; i < array.length-1; i++){
            int key = array[i+1];
            int j = 0;
            for(j = i; j >= 0 && key < array[j]; j--){
              array[j+1] = array[j];
            }
            array[j+1] = key;
        }

    }

    private static void insertSortWithGap(int[] array,int gap){
        /**
         * 分组之后，每组的第i个数互相比较
         *
         * 从第二组的第i个数 key 开始和第一组的第i个数进行比较 ，
         *      1)如果 key小，则交换，
         *      2)否则不交换，继续第二组的第 i+1 个数和第一组的第 i+1 个数进行比较
         * 第二组比较完之后，用下一组的第 i 个数和第二组的第 i 个数比较，再和第一组的第 i 个数进行比较
         *
         */
        for(int i = 0; i < array.length - gap; i++){
            int key = array[i + gap];
            int j;
            for(j = i; j >= 0 && key < array[j]; j -= gap){
                array[j+gap] = array[j];
            }
            array[j+gap] = key;
        }
    }

    public static void shellSort(int[] array){
        int gap = array.length;
        while(true){
            gap = gap/3 + 1;
            insertSortWithGap(array, gap);
            if(gap == 1){
                return;
            }
        }
    }

    public static void selectSort(int[] array){
        /**
         * 每次选最大的数
         *
         * 无序区间：[0,array.length - i)
         * 有序区间：[array.length - i,array.length)
         */

        for(int i = 0;i < array.length-1 ; i++){
            int max = 0;
        }

    }

    public static void heapSort(int[] array){

    }

    public static void main(String[] args) {

    }
}
