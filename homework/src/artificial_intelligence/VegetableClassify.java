package artificial_intelligence;

import java.util.Scanner;

/**
 * @author Maria
 * @program homework
 * @date 2019/11/21 15:51
 */
public class VegetableClassify {

    /**
     * 蔬菜分类：
     * 土豆、南瓜、番茄、黄瓜、茄子、苦瓜、冬瓜、白菜、青菜、紫甘蓝、西兰花、
     * 菜花、豆角、青椒、蘑菇、香菇、红薯、胡萝卜🥕
     * 木耳、金针菇
     * @param args
     */


    public static void main(String[] args) {
        final int NUM = 18;
        Scanner sc = new Scanner(System.in);
        System.out.println("蔬菜的特征如下：1.红色的、2.黄色的、3.绿色的、4.紫色的、" +
                            "5.白色的、"+"\n"+"6.黑色的、7.棕色的、8.灰色的" +
                            "9.甜的、10.辣的、"+"\n"+"11.苦的、12.酸的、13.圆的、" +
                            "14.长条的、15.菌类、"+"\n"+"16.可生食的、17.包含可食豆类的、" +
                            "18.青涩味的、19.不可生食的");
        int[] fact = new int[NUM];
        String[] feature = {"红色的","黄色的","绿色的","紫色的","白色的","黑色的","棕色的","灰色的",
                "甜的","辣的","苦的","酸的","圆的","长条的","菌类","可生食的","包含可食豆类的","青涩味的",
                "不可生食的"};
        String[] vegetable = {"土豆","南瓜","番茄","黄瓜","茄子","苦瓜","冬瓜","白菜","青菜","紫甘蓝","西兰花",
                "菜花","豆角","青椒","蘑菇","香菇","红薯","胡萝卜"};
        System.out.println("请输入描述该蔬菜特征的个数(0<num<18):");
        int num = sc.nextInt();
        System.out.println("请输入该蔬菜的特征描述的序号(按序号由小到大):");
        for(int i = 0 ; i < num; i++){
            fact[i] = sc.nextInt();
        }


    }
}
