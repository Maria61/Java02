package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/5/26 15:57
 */
public class ShenXinFu {

    public static int count = 0;

    /**
     * 果树种植
     */
    public static void tree(int[][] array, int i, int j, int M, int N){
        if(i == M  && j == N){
            count++;
            return;
        }
        if(i == M && j != N){
            i = 0;
            j = N + 1;
        }else if(j == N && i != M){
            j = 0;
            i = M + 1;
        }
        int x = i;
        int y = j;
        if(array[x][y] == 0){
            tree(array, x + 1, y, M, N);
        }else if(array[x][y] == 1){
            //判断左边是否有树
            if( x - 1 >= 0){
                if(array[x - 1][y] == 2){
                    tree(array, x + 1, y, M, N);
                }
            }
            //判断上边是否有树
            if( y - 1 >= 0){
                if(array[x][y - 1] == 2){
                    tree(array, x + 1, y, M, N);
                }
            }
            //周围没有树，可以选择种或者不种
            tree(array, x + 1, y, M, N);//选择不种
            array[x][y] = 2;//选择种
            tree(array, x + 1, y, M, N);
        }
        count++;
    }




    /**
     * 黄金时段
     */



}
