package java_experiment.n5;

/**
 * @author Maria
 * @program homework
 * @date 2020/1/1 0:20
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Info{
    public static void show(){
        JFrame frame=new JFrame("信息设置");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,250);
        frame.setLocation(250,250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel2=new JPanel();
        JButton b1=new JButton("Ok");
        JButton b2=new JButton("Clear");

        JPanel panel1=new JPanel();
        panel1.setLayout(new BorderLayout());
        JPanel panel11=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        JPanel panel12=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        JPanel panel13=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel label1=new JLabel("姓名:");
        JLabel label2=new JLabel("性别:");
        JLabel label3=new JLabel("年龄:");

        JTextField text1=new JTextField(12);
        JTextField text2=new JTextField(12);
        JTextField text3=new JTextField(12);

        JTextArea area=new JTextArea(5,12);

        JScrollPane panel3=new JScrollPane(area);
        area.setEditable(true);
        b1.addActionListener(e->{
            area.append(text1.getText()+"\n");
            area.append(text2.getText()+"\n");
            area.append(text3.getText()+"\n");
        });

        b2.addActionListener(e->{
            area.setText("");
        });

        panel11.add(label1);
        panel11.add(text1);
        panel12.add(label2);
        panel12.add(text2);
        panel13.add(label3);
        panel13.add(text3);
        panel1.add(panel11,BorderLayout.PAGE_START);
        panel1.add(panel12,BorderLayout.CENTER);
        panel1.add(panel13,BorderLayout.PAGE_END);
        panel2.add(b1);
        panel2.add(b2);
        frame.add(panel1,BorderLayout.PAGE_START);
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(panel3,BorderLayout.PAGE_END);
    }
}
public class Information {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Info::show);

    }

}

