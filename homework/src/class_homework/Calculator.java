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
    public JPanel panel2;
    public JButton[] bts1;
    public JTextField content;

    public Calculator() {
        setSize(400,400);//设置窗口大小
        setTitle("计算器");//设置窗口标题
        setLayout(null);
        content = new JTextField("0");
        content.setHorizontalAlignment(JTextField.RIGHT);
        panel1=new JPanel();
        panel2=new JPanel();
        panel2.add(content);
        panel1.setSize(300, 200);
        panel1.setLocation(40, 100);
        panel1.setLayout(new GridLayout(6,4));
        panel2.setSize(300, 30);
        panel2.setLocation(40, 50);
        panel2.setLayout(new GridLayout(1,1));
        String[] strs1={"%","√x","x²","1/x","CE","C","✘","÷","7","8","9","×",
                        "4","5","6","－","1","2","3","+","+/-","0",".","="};
        bts1=new JButton[24];
        for(int i=0;i<bts1.length;i++)
        {
            bts1[i]=new JButton(strs1[i]);
            panel1.add(bts1[i]);
        }
        this.add(panel1);
        this.add(panel2);
        setVisible(true);//设置窗口可见
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
