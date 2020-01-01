package java_experiment.n5;

/**
 * @author Maria
 * @program homework
 * @date 2020/1/1 0:22
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Calcu{
    private static double r;
    static StringBuffer op1;
    static StringBuffer op2;
    public static void show(){
        JFrame frame=new JFrame("简易计算器");
        frame.setLayout(null);
        frame.setSize(400,450);
        frame.setLocation(0,0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //按键面板
        JPanel panel1=new JPanel(new GridLayout(4,4));
        panel1.setSize(400,250);
        panel1.setLocation(0,100);
        String[] str1={
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+"};
        JButton[] but1=new JButton[16];
        for(int i=0;i<16;i++) {
            but1[i]=new JButton(str1[i]);
            panel1.add(but1[i]);
        }
        //归零按键
        JButton buth=new JButton("AC");
        buth.setSize(400,50);
        buth.setLocation(0,350);
        //输入文本框
        JTextField text=new JTextField("                                                                           "
                + "                                            0.0");
        text.setSize(400,100);
        text.setLocation(0, 0);

        //为按钮绑定事件
        StringBuffer shi=new StringBuffer();
        for(int i=0;i<16;i++) {
            String con=but1[i].getText();
            if(con.equals("=")) {
                but1[i].addActionListener(e->{
                    //shi.append(con);
                    text.setText(shi.toString());
                    //System.out.println(shi.toString());
                    r=cal(shi.toString());
                    //System.out.println(r);
                    text.setText(String.valueOf(r));
                });
            }
            else {
                but1[i].addActionListener(e->{
                    shi.append(con);
                    text.setText(shi.toString());
                });
            }
        }
        String s="/0";
        //归零按钮绑定事件
        buth.addActionListener(e->{
            text.setText("                                                                           "
                    + "                                            0.0");
            op1.replace(0,op1.length()-1,s);
            op2.replace(0,op2.length()-1,s);
        });

        frame.add(text);
        frame.add(panel1);
        frame.add(buth);
    }
    //计算
    private static double cal(String str) {
        int i;
        double result=0.0;
        double result1=0.0;
        double result2=0.0;
        char op='\0';
        //计算第一个操作数
        op1=new StringBuffer();
        for(i=0;i<str.length();i++) {
            if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/') {
                op=str.charAt(i);
                break;
            }
            else {
                op1.append(str.charAt(i));
            }
        }
        //计算第二个操所数
        op2=new StringBuffer();
        for(int j=i+1;j<str.length();j++) {
            op2.append(str.charAt(j));
        }
        result1=Double.parseDouble(op1.toString());
        result2=Double.parseDouble(op2.toString());
		/*System.out.println(result1);
		System.out.println(result2);
		System.out.println(op);*/
        String operate=toStr(op);
        if("+".equals(operate)) {
            //System.out.println("+");
            result=result1+result2;
        }
        if("-".equals(operate)) {
            result=result1-result2;
        }
        if("*".equals(operate)) {
            result=result1*result2;
        }
        if("/".equals(operate)) {
            result=result1/result2;
        }
        //System.out.println(result);
        return result;
    }
    //重写toString()方法
    private static String toStr(char c) {
        return String.valueOf(c);
    }
}
public class Calculator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calcu::show);
    }

}
