package class_homework;

import javax.swing.*;
import java.awt.*;

/**
 * @author Maria
 * @program homework
 * @date 2019/11/2 23:25
 */
public class Calculator extends JFrame{
    public JPanel panel1;
    public JButton[] bts1;

    public Calculator() {
        setSize(400,400);//设置窗口大小
        setTitle("计算器");//设置窗口标题
        setLayout(null);
        panel1=new JPanel();
        panel1.setSize(300, 200);
        panel1.setLocation(30, 30);
        panel1.setLayout(new GridLayout(6,4));
        String[] strs1={"%","√x","x²","1/x","CE","C","✘","÷","7","8","9","×",
                        "4","5","6","－","1","2","3","+"};
        bts1=new JButton[8];
        for(int i=0;i<bts1.length;i++)
        {
            bts1[i]=new JButton(strs1[i]);
            panel1.add(bts1[i]);
        }
        this.add(panel1);
        setVisible(true);//设置窗口可见
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
