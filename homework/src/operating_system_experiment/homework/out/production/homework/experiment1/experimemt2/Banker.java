package operating_system_experiment.homework.out.production.homework.experiment1.experimemt2;

public class Banker {

    //系统现在可以分配的第 i 类资源对应的资源数
    private  int[] available;
    //最大需求矩阵：第 i 个进程对第 j 类资源的 最大需求数
    private  int[][] max;
    //已申请到的资源矩阵： 第 i 个进程已经得到 第 j 类资源的数目
    private  int[][] allocation;
    //需求矩阵：第 i 个进程对第 j 类资源的 目前需求量
    private  int[][] need;
    //进程数组
    private  int[] ps;

    public int[] getAvailable() {
        return available;
    }

    public void setAvailable(int[] available) {
        this.available = available;
    }

    public int[][] getMax() {
        return max;
    }

    public void setMax(int[][] max) {
        this.max = max;
    }

    public int[][] getAllocation() {
        return allocation;
    }

    public void setAllocation(int[][] allocation) {
        this.allocation = allocation;
    }

    public int[][] getNeed() {
        return need;
    }

    public void setNeed(int[][] need) {
        this.need = need;
    }

    public int[] getPs() {
        return ps;
    }

    public void setPs(int[] ps) {
        this.ps = ps;
    }

    /**
     *
     * @param re  单个进程对每类资源的需求
     */
    public  void bankerMethod(int[] re,int p){
        if(re.length == 0){
            return;
        }
        for(int j = 0; j < re.length; j++){
            if(re[j] <= need[p][j]){//请求数小于需求数

                if(re[j] <= available[j]){//请求数小于可分配资源数
                    //尝试分配资源
                    available[j] = available[j] - re[j];
                    allocation[p][j] = allocation[p][j] + re[j];
                    need[p][j] = need[p][j] - re[j];
                    //安全性判断
                    if(!safeMethod()){
                        //如果不安全，撤回之前的分配操作
                        available[j] = available[j] + re[j];
                        allocation[p][j] = allocation[p][j] - re[j];
                        need[p][j] = need[p][j] + re[j];
                        System.out.println((p + 1)+" 进程分配资源失败！原因：系统分配资源后将处于不安全状态！");
                        return;
                    }
                }else{
                    System.out.println((p + 1)+" 进程所需资源"+(j+1)+"不足，进入等待状态！");
                    return;
                }
            }else{
                System.out.println((p + 1)+"进程请求"+(j+1)+"资源数超出需求范围，请求出错！");
                return;
            }
        }
        System.out.println((p + 1)+" 进程资源已成功分配！");
    }

    /**
     * 安全性检查
     * @return 返回该分配是否安全
     */

    public  boolean safeMethod(){
        //需求数组
        int[] work = available;
        //系统是否有足够的资源分配给进程
        boolean[] finish = new boolean[ps.length];
        boolean flag = true;
        //遍历finish,判断分配资源是否合理
        for(int i = 0; i < ps.length; i++){
            if(finish[i] == false){
                for(int j = 0; j < need[i].length; j++){
                    if(need[i][j] > work[j]){//需求资源数大于可分配资源数
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    for(int j = 0; j < work.length ; j++){
                        work[j] = work[j] + allocation[i][j];
                        finish[i] = true;
                    }
                }
                if(flag == false){
                    break;
                }
            }
        }

        //遍历finish数组，判断是否所有进程的finish值都为true
        for(int i = 0; i < finish.length; i++){
            if(finish[i] == false){
                return false;//不安全
            }
        }
        return true;//安全
    }


}
