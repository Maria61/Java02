package project;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener{
	 //���崰���д��ڵĿؼ�
		JLabel userLa,passLa;
		JTextField userTxt;
		//�û���
		JPasswordField passTxt;
		//����
		JButton loBt,quitBt;
		
		//�����������е�������壨����ѡ�����Ͳ�����壩
		JPanel selectPa;
		JButton[] selectBts;
		
		
		JPanel controlPa;
		//���ҵĿؼ� 
		JLabel numLa,nameLa,sexLa,addLa,deleteLa,altLa,newNameLa,newNumLa,newSexLa;
		JTextField numTxt,nameTxt,sexTxt,addTxt,deleteTxt,altTxt,newNumTxt,newNameTxt,newSexTxt;
		JButton findBt,addBt,deleteBt,altBt;
		
		public LoginFrame()
		{
			//Dimension dime=new Dimension(400,300);
			//this.setSize(dime);
			this.setSize(400, 380);//���ô���Ĵ�С
			this.setTitle("��¼����");//���ô������
			//���´����Ǵ����ؼ����ڷŵ�������
			/*userLa=new JLabel("�û���");//������ǩ
			this.add(userLa,BorderLayout.WEST);//����ǩ�ŵ�������
			//userLa=new JLabel();
			//userLa.setText("�û���");
			//userLa.setForeground(Color.RENORTHD);
			userTxt=new JTextField();//�����ı���
			this.add(userTxt,BorderLayout.SOUTH);//���ı���ŵ�������
			passLa=new JLabel("��   ��");//������ǩ
			this.add(passLa,BorderLayout.EAST);//����ǩ�ŵ�������
			passTxt=new JPasswordField();//���������
			this.add(passTxt,BorderLayout.NORTH);//�������ŵ�������
			loBt=new JButton("��¼");//������ť
			this.add(loBt,BorderLayout.CENTER);//����ť�ŵ�������
			//quitBt=new JButton("�˳�");//������ť
			//this.add(quitBt);//����ť�ŵ�������*/
			//this.setLayout(new FlowLayout());
			//������Ĳ��ַ�ʽ��Ϊ�����ֶ���
			
			/*userLa=new JLabel("�û���");//������ǩ
			this.add(userLa);//����ǩ�ŵ�������
			//userLa=new JLabel();
			//userLa.setText("�û���");
			//userLa.setForeground(Color.RENORTHD);
			userTxt=new JTextField();//�����ı���
			this.add(userTxt);//���ı���ŵ�������
			passLa=new JLabel("��   ��");//������ǩ
			this.add(passLa);//����ǩ�ŵ�������
			passTxt=new JPasswordField();//���������
			this.add(passTxt);//�������ŵ�������
			loBt=new JButton("��¼");//������ť
			this.add(loBt);//����ť�ŵ�������
			quitBt=new JButton("�˳�");//������ť
			this.add(quitBt);//����ť�ŵ�������*/
			/*this.setLayout(new GridLayout(3,2));
			userLa=new JLabel("�û���");//������ǩ
			this.add(userLa);//����ǩ�ŵ�������
			//userLa=new JLabel();
			//userLa.setText("�û���");
			//userLa.setForeground(Color.RENORTHD);
			userTxt=new JTextField();//�����ı���
			this.add(userTxt);//���ı���ŵ�������
			passLa=new JLabel("��   ��");//������ǩ
			this.add(passLa);//����ǩ�ŵ�������
			passTxt=new JPasswordField();//���������
			this.add(passTxt);//�������ŵ�������
			loBt=new JButton("��¼");//������ť
			this.add(loBt);//����ť�ŵ�������
			quitBt=new JButton("�˳�");//������ť
			this.add(quitBt);//����ť�ŵ�������*/
			
			
			this.setLayout(null);
			//���ô���Ĳ��ֶ���Ϊ��
			userLa=new JLabel("�û���");//������ǩ
			userLa.setSize(60, 30);
			userLa.setLocation(90, 50);
			this.add(userLa);//����ǩ�ŵ�������
			
			userTxt=new JTextField();//�����ı���
			userTxt.setSize(150, 30);
			userTxt.setLocation(160, 50);
			this.add(userTxt);//���ı���ŵ�������
			
			passLa=new JLabel("��   ��");//������ǩ
			passLa.setSize(60, 30);
			passLa.setLocation(90, 100);
			this.add(passLa);//����ǩ�ŵ�������
			passTxt=new JPasswordField();//���������
			passTxt.setSize(150, 30);
			passTxt.setLocation(160, 100);
			this.add(passTxt);//�������ŵ�������
			loBt=new JButton("��¼");//������ť
			loBt.setSize(60, 30);
			loBt.setLocation(120, 150);
			loBt.addActionListener(this);
			this.add(loBt);//����ť�ŵ�������
			quitBt=new JButton("�˳�");//������ť
			quitBt.setSize(60, 30);
			quitBt.setLocation(210, 150);
			quitBt.addActionListener(this);
			this.add(quitBt);//����ť�ŵ�������*/
			
			
			this.setVisible(true);//���ô���ɼ�
//			System.out.println("1");
			
		}
		
		public void actionPerformed(ActionEvent e)
		{
//			System.out.println("2");
			JButton bt=(JButton)e.getSource();
			if(bt.getText().equals("��¼"))
			{
			String username=userTxt.getText().trim();
			//��ȡ�û���
			String password=passTxt.getText().trim();
			//��ȡѧ��
			LoginDAO dao=new LoginDAO();
//			System.out.println("3");
			//����ѧ���ļ��������
			if(password.equals(dao.findPasswordByName(username).getPassword()))
			{
//				System.out.println("4");
				
				this.setVisible(false);
				this.getContentPane().removeAll();
				//����ǰ��¼��������
				MainFrame main=new MainFrame();
				//���������ڣ�����ʾ*/
				
				
			
			}
			}
			else if(bt.getText().equals("�˳�"))
			{
				this.setVisible(false);
				this.getContentPane().removeAll();
			}
		}
			
}
