package java_experiment.n5;

/**
 * @author Maria
 * @program homework
 * @date 2020/1/1 0:14
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Copy1{
    public static void show(){
        JFrame frame=new JFrame("文本框内容复制");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,250);
        frame.setLocation(250,250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label=new JLabel("Destination");
        JTextField text=new JTextField(12);
        JButton button=new JButton("一键复制");
        button.addActionListener(e->{
            label.setText(text.getText());
        });

        JPanel panel=new JPanel();
        panel.add(button);
        panel.add(label);
        panel.add(text);
        frame.add(panel);
    }
}
public class Copy {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Copy1::show);

    }

}
