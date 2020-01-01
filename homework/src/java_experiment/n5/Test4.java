package java_experiment.n5;

/**
 * @author Maria
 * @program homework
 * @date 2020/1/1 0:16
 */
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


class Border{
    public static void create() {
        JFrame frame=new JFrame("GUITest");
        frame.setSize(400, 400);
        frame.setLocation(200, 300);
        frame.setLayout(new BorderLayout());
        JPanel panel1=new JPanel();
        panel1.setLayout(new BorderLayout());
        JButton but1=new JButton("but1");
        JButton but2=new JButton("but2");
        JButton but3=new JButton("but3");
        panel1.add(but1,BorderLayout.PAGE_START);
        panel1.add(but2,BorderLayout.CENTER);
        panel1.add(but3,BorderLayout.PAGE_END);
        JPanel panel2=new JPanel();
        JButton but5=new JButton("but5");
        JButton but6=new JButton("but6");
        JButton but7=new JButton("but7");
        but7.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {

            }
            public void mouseClicked(MouseEvent e) {

            }
            public void mouseExited(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getLocationOnScreen());
            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });
        panel2.setLayout(new BorderLayout());
        panel2.add(but5,BorderLayout.PAGE_START);
        panel2.add(but6,BorderLayout.CENTER);
        panel2.add(but7,BorderLayout.PAGE_END);
        frame.add(panel1,BorderLayout.LINE_START);
        frame.add(panel2,BorderLayout.LINE_END);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
public class Test4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Border::create);


    }
}