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
     */

    /**
     * "1.红色的、2.黄色的、3.绿色的、4.紫色的、" +
     * "5.白色的、6.黑色的、7.棕色的、8.灰色的"+"\n"+
     * "9.甜的、10.辣的、11.苦的、12.酸的、13.青涩味、14.无味"+"\n"+
     * "15.圆的、" +"16.长条的、"+"\n"+
     * "16.不可生食的、17.可生食的、"+"\n"+
     * "18.包含可食豆类的、19.菌类、
     *
     * 颜色、形状、味道、是否可生食
     */

    static String[] feature = {"红色的","黄色的","绿色的","紫色的",
            "白色的","黑色的","棕色的","灰色的",
            "甜的","辣的","苦的","酸的","青涩味","无味",
            "圆的","长条的","菜花状",
            "不可生食的","可生食的"};
    static String[] vegetable = {"土豆","南瓜","番茄","黄瓜","茄子","苦瓜","冬瓜","白菜","青菜","紫甘蓝","西兰花",
            "菜花","豆角","青椒","蘑菇","香菇","红薯","胡萝卜","木耳","金针菇"};
    private static void rules(int[] fact) {
        Scanner sc = new Scanner(System.in);
        if (feature[fact[0] - 1].equals("红色的")) {
            if (feature[fact[1] - 1].equals("圆的")) {
                if (feature[fact[2] - 1].equals("酸的")) {
                    if (feature[fact[3] - 1].equals("可生食的")) {
                        System.out.println("结果为：番茄");
                        return;
                    }
                }
            }
        }
        if (feature[fact[0] - 1].equals("黄色的")) {
            if (feature[fact[1] - 1].equals("圆的")) {
                if (feature[fact[2] - 1].equals("无味")) {
                    if (feature[fact[3] - 1].equals("不可生食的")) {
                        System.out.println("结果为：土豆");
                        return;
                    }
                }
            }
        }
        if (feature[fact[0] - 1].equals("黄色的")) {
            if (feature[fact[1] - 1].equals("圆的")) {
                if (feature[fact[2] - 1].equals("甜的")) {
                    if (feature[fact[3] - 1].equals("不可生食的")) {
                        System.out.println("结果为：南瓜");
                        return;
                    }
                }
            }
        }
        if (feature[fact[0] - 1].equals("绿色的")) {
            if (feature[fact[1] - 1].equals("长条的")) {
                if (feature[fact[2] - 1].equals("青涩味")) {
                    if (feature[fact[3] - 1].equals("可生食的")) {
                        System.out.println("结果为：黄瓜");
                        return;
                    }
                }
            }
        }
        if (feature[fact[0] - 1].equals("绿色的")) {
            if (feature[fact[1] - 1].equals("长条的")) {
                if (feature[fact[2] - 1].equals("无味")) {
                    if (feature[fact[3] - 1].equals("不可生食的")) {
                        System.out.println("条件不足，请选择特征：");
                        System.out.println("1.包含可食豆类的  2.不包含可食豆类的");
                        int f = sc.nextInt();
                        if(f == 1){
                            System.out.println("结果为：豆角");
                        }else{
                            System.out.println("结果为：冬瓜");
                        }
                        return;
                    }
                }
            }
        }
        if (feature[fact[0] - 1].equals("绿色的")) {
            if (feature[fact[1] - 1].equals("长条的")) {
                if (feature[fact[2] - 1].equals("苦味")) {
                    if (feature[fact[3] - 1].equals("可生食的")) {
                        System.out.println("结果为：苦瓜");
                        return;
                    }
                }
            }
        }
        if (feature[fact[0] - 1].equals("紫色的")) {
            if (feature[fact[1] - 1].equals("长条的")) {
                if (feature[fact[2] - 1].equals("无味")) {
                    if (feature[fact[3] - 1].equals("不可生食的")) {
                        System.out.println("结果为：茄子");
                        return;
                    }
                }
            }
        }
        if (feature[fact[0] - 1].equals("绿色的")) {
            if (feature[fact[1] - 1].equals("长条的")) {
                if (feature[fact[2] - 1].equals("苦味")) {
                    if (feature[fact[3] - 1].equals("可生食的")) {
                        System.out.println("结果为：苦瓜");
                        return;
                    }
                }
            }
        }
        System.out.println("现有事实无法推断出结果！");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("蔬菜的特征如下：" +"\n"+
                            "1.红色的、2.黄色的、3.绿色的、4.紫色的、" +
                            "5.白色的、6.黑色的、7.棕色的、8.灰色的"+"\n"+
                            "9.甜的、10.辣的、11.苦的、12.酸的、13.青涩味、14.无味"+"\n"+
                            "15.圆的、16.长条的、17.菜花状"+"\n"+
                            "18.不可生食的、19.可生食的、"+"\n");
        int[] fact = new int[4];
        System.out.println("请依次输入四个数字表述蔬菜四个特征(颜色、形状、味道、是否可生食):");
        for(int i = 0 ; i < 4; i++){
            fact[i] = sc.nextInt();
        }
        rules(fact);

    }


}
