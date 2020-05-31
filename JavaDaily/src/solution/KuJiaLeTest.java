package solution;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/5/27 17:26
 */
public class KuJiaLeTest {


    /**
     * 酷家乐面试写代码
     */

    /**
     * { 9 8 2  4  5 7  }  数组 找到和是 sum =10
     *
     */
    public static int[] find(int[] array, int sum){
        int[] res = new int[2];
        for(int i = 0; i < array.length; i++){
            boolean flag = false;
            for(int j = i + 1; j < array.length; j++){
                if(array[i] + array[j] == sum){
                    res[0] = array[i];
                    res[1] = array[j];
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,2,4,5,7};
        int[] res = find(arr,10);
        System.out.println(Arrays.toString(res));
    }

    public void method(){
       /**
        一.学生表(学生id，姓名，性别，分数)student（s_id，name,sex,score）
        班级表（班级id，班级名称）class（c_id，c_name）
        学生班级表（班级id，学生id）student_class(s_id,c_id)(考察三表联查)
        1.查询一班得分在80分以上的学生
        select * from student where class.c_id=1 and class.c_id = student_class.c_id and core >= 80
        2.查询所有班级的名称，和所有班中女生人数和女生的平均分
        select c_name,count(s_id),avg(score) where student_class.s_id = student.s_id and student.sex='女'
         */




    }
}
