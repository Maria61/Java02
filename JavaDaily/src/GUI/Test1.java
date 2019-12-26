package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/26 9:47
 */
public class Test1 {
    static void creatJFrame() {
        JFrame frame = new JFrame("test1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);//设置窗口可见

        JDialog dialog = new JDialog(frame, "非模态对话窗口");
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.setSize(200, 200);
        dialog.setVisible(true);

        JPanel panel = new JPanel();
        panel.setSize(300, 200);
        panel.setLocation(1000, 1000);
        panel.setLayout(new GridLayout(1, 4));
        panel.setVisible(true);

        JTextField content = new JTextField("文本框");
        content.setSize(50, 10);
        content.setLocation(50, 50);
        panel.add(content);
        JTextArea area = new JTextArea("文本域");
        area.setSize(50, 100);
        area.setLocation(70, 70);
        panel.add(area);
        JButton button = new JButton("button1");
        panel.add(button);

        JCheckBox box = new JCheckBox("box");
        panel.add(box);

        JLabel jLabel = new JLabel("label");
        panel.add(jLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setSize(100, 100);
        comboBox.setLocation(100, 100);
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");
        frame.add(comboBox);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        creatJFrame();
    }
}
