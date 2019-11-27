package algorithm_experiment;

/**
 * @author Maria
 * @program homework
 * @date 2019/11/27 16:26
 */
public class Experiment1127 {
    static int[] queen = new int[9];
    static int count = 0;
    public static void nQueen(int now){
        int i;
        if(now==9){
            for(i=0;i<9;i++){
                System.out.print(queen[i]+" ");
            }
            count++;
            System.out.println();

            return;
        }

        int j;
        for(i=0;i<9;i++){//i表示正在放的皇后的位置，即该皇后的纵坐标
            for(j=0;j<now;j++){//j表示已经放好的皇后的编号
                if(i==queen[j]||Math.abs(now-j)==Math.abs(i-queen[j])){
                    break;
                }
            }
            if(j==now){
                queen[now]=i;
                nQueen(now+1);
            }
        }
    }
    public static void main(String[] args) {
            nQueen(0);
//        System.out.println(count);
    }
}
