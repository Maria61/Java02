package java_experiment.n5;

/**
 * @author Maria
 * @program homework
 * @date 2020/1/1 0:24
 */

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.sql.*;
import java.util.Scanner;

class CreateGraph{
    public static Connection conn;
    public static Statement stmt;
    //界面设计
    public static void createAndShow() {
        try{
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            String url="jdbc:mysql://localhost:3306/student?" +
                    "serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
            String user="root";
            String password="899900";
            conn= DriverManager.getConnection(url,user,password);
            //获取statement对象
            stmt=conn.createStatement();

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        JFrame frame=new JFrame("学生管理");
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setBackground(Color.lightGray);
        frame.setLocation(0,0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] labels={"学号","姓名"};
        JLabel[] label=new JLabel[2];
        JTextField[] text=new JTextField[2];
        for(int i=0;i<2;i++){
            label[i]=new JLabel(labels[i]);
            label[i].setSize(80,50);
            label[i].setLocation(70,70*i+70);
            frame.add(label[i]);
        }
        for(int i=0;i<2;i++){
            text[i]=new JTextField();
            text[i].setSize(200,50);
            text[i].setBackground(Color.white);
            text[i].setLocation(170,70*i+70);
            frame.add(text[i]);
        }
        String[] buttons={"添加","删除"};
        JButton[] button=new JButton[2];
        for(int i=0;i<2;i++) {
            button[i] = new JButton(buttons[i]);
            button[i].setSize(100, 50);
            button[i].setBackground(Color.GRAY);
            button[i].setLocation(110*i+110, 250);
            frame.add(button[i]);
        }
        for(int i=0;i<2;i++){
            if(button[i].getText().equals("添加")){
                int j=i;
                button[j].addActionListener(e1->{
                    try{
                        if(!text[0].getText().equals("")&&!text[1].getText().equals("")) {
                            String sql="insert into student_info(sno,name) values('"+text[0].getText(0,7)+"','"+text[1].getText(0,6)+"')";
                            stmt.execute(sql);
                            stmt.close();
                            conn.close();
                        }
                    }catch(SQLException | BadLocationException e){
                        e.printStackTrace();
                    }
                });

            }
            else{
                int j=i;
                button[j].addActionListener(e1->{
                    try{
                        if(!text[0].getText().equals("")) {
                            String sql="delete from student_info where sno='"+text[0].getText()+"'";
                            stmt.execute(sql);
                            stmt.close();
                            conn.close();
                        }

                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                });
            }
        }
    }

}
public class DataOperate {
    public static void main(String[] args){
        SwingUtilities.invokeLater(CreateGraph::createAndShow);
    }
}
