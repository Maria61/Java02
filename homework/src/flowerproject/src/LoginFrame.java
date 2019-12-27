package flowerproject.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener{
	 //定义窗口中存在的控件
		JLabel userLa,passLa;
		JTextField userTxt;
		//用户名
		JPasswordField passTxt;
		//密码
		JButton loBt,quitBt;
		
		//定义主窗口中的两个面板（操作选择面板和操作面板）
		JPanel selectPa;
		JButton[] selectBts;
		
		
		JPanel controlPa;
		//查找的控件 
		JLabel numLa,nameLa,sexLa,addLa,deleteLa,altLa,newNameLa,newNumLa,newSexLa;
		JTextField numTxt,nameTxt,sexTxt,addTxt,deleteTxt,altTxt,newNumTxt,newNameTxt,newSexTxt;
		JButton findBt,addBt,deleteBt,altBt;
		
		public LoginFrame()
		{
			//Dimension dime=new Dimension(400,300);
			//this.setSize(dime);
			this.setSize(400, 380);//设置窗体的大小
			this.setTitle("登录窗口");//设置窗体标题
			//以下代码是创建控件并摆放到窗口中
			/*userLa=new JLabel("用户名");//创建标签
			this.add(userLa,BorderLayout.WEST);//将标签放到窗体上
			//userLa=new JLabel();
			//userLa.setText("用户名");
			//userLa.setForeground(Color.RENORTHD);
			userTxt=new JTextField();//创建文本框
			this.add(userTxt,BorderLayout.SOUTH);//将文本框放到窗体上
			passLa=new JLabel("密   码");//创建标签
			this.add(passLa,BorderLayout.EAST);//将标签放到窗体上
			passTxt=new JPasswordField();//创建密码框
			this.add(passTxt,BorderLayout.NORTH);//将密码框放到窗体上
			loBt=new JButton("登录");//创建按钮
			this.add(loBt,BorderLayout.CENTER);//将按钮放到窗体上
			//quitBt=new JButton("退出");//创建按钮
			//this.add(quitBt);//将按钮放到窗体上*/
			//this.setLayout(new FlowLayout());
			//将窗体的布局方式改为流布局对象
			
			/*userLa=new JLabel("用户名");//创建标签
			this.add(userLa);//将标签放到窗体上
			//userLa=new JLabel();
			//userLa.setText("用户名");
			//userLa.setForeground(Color.RENORTHD);
			userTxt=new JTextField();//创建文本框
			this.add(userTxt);//将文本框放到窗体上
			passLa=new JLabel("密   码");//创建标签
			this.add(passLa);//将标签放到窗体上
			passTxt=new JPasswordField();//创建密码框
			this.add(passTxt);//将密码框放到窗体上
			loBt=new JButton("登录");//创建按钮
			this.add(loBt);//将按钮放到窗体上
			quitBt=new JButton("退出");//创建按钮
			this.add(quitBt);//将按钮放到窗体上*/
			/*this.setLayout(new GridLayout(3,2));
			userLa=new JLabel("用户名");//创建标签
			this.add(userLa);//将标签放到窗体上
			//userLa=new JLabel();
			//userLa.setText("用户名");
			//userLa.setForeground(Color.RENORTHD);
			userTxt=new JTextField();//创建文本框
			this.add(userTxt);//将文本框放到窗体上
			passLa=new JLabel("密   码");//创建标签
			this.add(passLa);//将标签放到窗体上
			passTxt=new JPasswordField();//创建密码框
			this.add(passTxt);//将密码框放到窗体上
			loBt=new JButton("登录");//创建按钮
			this.add(loBt);//将按钮放到窗体上
			quitBt=new JButton("退出");//创建按钮
			this.add(quitBt);//将按钮放到窗体上*/
			
			
			this.setLayout(null);
			//设置窗体的布局对象为空
			userLa=new JLabel("用户名");//创建标签
			userLa.setSize(60, 30);
			userLa.setLocation(90, 50);
			this.add(userLa);//将标签放到窗体上
			
			userTxt=new JTextField();//创建文本框
			userTxt.setSize(150, 30);
			userTxt.setLocation(160, 50);
			this.add(userTxt);//将文本框放到窗体上
			
			passLa=new JLabel("密   码");//创建标签
			passLa.setSize(60, 30);
			passLa.setLocation(90, 100);
			this.add(passLa);//将标签放到窗体上
			passTxt=new JPasswordField();//创建密码框
			passTxt.setSize(150, 30);
			passTxt.setLocation(160, 100);
			this.add(passTxt);//将密码框放到窗体上
			loBt=new JButton("登录");//创建按钮
			loBt.setSize(60, 30);
			loBt.setLocation(120, 150);
			loBt.addActionListener(this);
			this.add(loBt);//将按钮放到窗体上
			quitBt=new JButton("退出");//创建按钮
			quitBt.setSize(60, 30);
			quitBt.setLocation(210, 150);
			quitBt.addActionListener(this);
			this.add(quitBt);//将按钮放到窗体上*/
			
			
			this.setVisible(true);//设置窗体可见
//			System.out.println("1");
			
		}
		
		public void actionPerformed(ActionEvent e)
		{
//			System.out.println("2");
			JButton bt=(JButton)e.getSource();
			if(bt.getText().equals("登录"))
			{
			String username=userTxt.getText().trim();
			//获取用户名
			String password=passTxt.getText().trim();
			//获取学号
			LoginDAO dao=new LoginDAO();
//			System.out.println("3");
			//创建学生文件处理对象
			if(password.equals(dao.findPasswordByName(username).getPassword()))
			{
//				System.out.println("4");
				
				this.setVisible(false);
				this.getContentPane().removeAll();
				//将当前登录窗口隐藏
				MainFrame main=new MainFrame();
				//创建主窗口，并显示*/
				
				
			
			}
			}
			else if(bt.getText().equals("退出"))
			{
				this.setVisible(false);
				this.getContentPane().removeAll();
			}
		}
			
}
