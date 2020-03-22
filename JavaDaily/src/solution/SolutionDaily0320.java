package solution;

import java.io.InputStream;
import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/22 15:29
 */
public class SolutionDaily0320 {
    /**
     * 顺时针打印矩阵
     * @param mat
     * @param n
     * @param m
     * @return
     */
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int minx = 0;
        int miny = -1;
        int maxx = n;
        int maxy = m;
        int[] re = new int[n*m];
        int index = 0;
        int i = 0;
        int j = 0;
        while(index < n*m){
            while(index < n*m && j < maxy){//右移
                re[index++] = mat[i][j];
                j++;
            }
            maxy -= 1;
            j--;
            i++;
            while(index < n*m && i < maxx){//下移
                re[index++] = mat[i][j];
                i++;
            }
            maxx -= 1;
            i--;
            j--;
            while(index < n*m && j > miny){//左移
                re[index++] = mat[i][j];
                j--;
            }
            miny += 1;
            j++;
            i--;
            while(index < n*m && i > minx){//上移
                re[index++] = mat[i][j];
                i--;
            }
            minx += 1;
            i++;
            j++;
        }
        return re;
    }
    public static void main1(String[] args) {
        int[][] mat = {{1,2}};
        System.out.println(Arrays.toString(clockwisePrint(mat,1,2)));
    }

    /**
     * 左右最值最大差
     * @param A
     * @param n
     * @return
     */
    public static int findMaxGap(int[] A, int n) {
        // write code here
        int re = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            int maxl = findMax(A,0,i);//[0,i]//最大值的下标
            int maxr = findMax(A,i+1,n - 1);//[i+1,n-1]
            int gap = Math.abs(A[maxl] - A[maxr]);
            re = Math.max(re,gap);
        }
        return re;
    }

    private static int findMax(int[] a, int l, int r) {
        int max = a[l];
        int re = l;
        for(int i = l; i <= r; i++){
            if(a[i] > max){
                re = i;
                max = a[i];
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        System.out.println(findMaxGap(a,5));
    }
}
