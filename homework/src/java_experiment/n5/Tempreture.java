package java_experiment.n5;

/**
 * @author Maria
 * @program homework
 * @date 2020/1/1 0:09
 */
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
//C*1.8+32=F
class TemCon{
    public static void show(){
        JFrame frame=new JFrame("温度转换");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,250);
        frame.setLocation(250,250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea area1=new JTextArea(5,12);
        JLabel lab1=new JLabel("摄氏温度");
        JScrollPane p1=new JScrollPane(area1);
        p1.add(lab1);
        area1.setEditable(true);

        JTextArea area2=new JTextArea(5,12);
        JLabel lab2=new JLabel("华氏温度");
        JScrollPane p2=new JScrollPane(area2);
        p2.add(lab2);
        area2.setEditable(true);

        JPanel panel=new JPanel();
        JButton b1=new JButton("摄氏按钮");
        JButton b2=new JButton("华氏按钮");

        b1.addActionListener(e->{
            String content=area2.getText();
            double f=Double.parseDouble(content);
            double c=(f-32)/1.8;
            area1.append(String.valueOf(c)+"C\n");
            area2.setText("");
        });

        b2.addActionListener(e->{
            String content1=area1.getText();
            double c=Double.parseDouble(content1);
            double f=c*1.8+32;
            area2.append(String.valueOf(f)+"F\n");
            area1.setText("");
        });

        frame.add(p1,BorderLayout.PAGE_START);
        frame.add(p2,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.PAGE_END);
        panel.add(b1);
        panel.add(b2);
    }
}
public class Tempreture {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemCon::show);
    }

}


