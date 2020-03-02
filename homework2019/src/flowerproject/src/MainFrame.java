package flowerproject.src;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;



public class MainFrame extends JFrame implements ActionListener
{
	JLabel nameLa,familyLa;
	JTextField nameTxt,familyTxt;
	JButton nameFBt,familyFBt,addBt,delBt,upBt;
	JTable table;
	JScrollPane panel;
	
	public MainFrame()
	{
		this.setSize(800,600);
		this.setTitle("花卉信息管理");
		this.setLayout(null);
		nameLa=new JLabel("花名");
		nameLa.setSize(60, 30);
		nameLa.setLocation(30,30);
		this.add(nameLa);
		nameTxt=new JTextField();
		nameTxt.setSize(150, 30);
		nameTxt.setLocation(90,30);
		this.add(nameTxt);
		nameFBt=new JButton("花名查找");
		nameFBt.setSize(90, 30);
		nameFBt.setLocation(280,30);
		nameFBt.addActionListener(this);
		this.add(nameFBt);
		
		familyLa=new JLabel("所属科");
		familyLa.setSize(60, 30);
		familyLa.setLocation(410,30);
		this.add(familyLa);
		familyTxt=new JTextField();
		familyTxt.setSize(150, 30);
		familyTxt.setLocation(470,30);
		this.add(familyTxt);
		familyFBt=new JButton("所属科查找");
		familyFBt.setSize(90, 30);
		familyFBt.setLocation(660,30);
		familyFBt.addActionListener(this);
		this.add(familyFBt);
		
		addBt=new JButton("增加");
		addBt.setSize(60, 30);
		addBt.setLocation(30,90);
		addBt.addActionListener(this);
		this.add(addBt);
		delBt=new JButton("删除");
		delBt.setSize(60, 30);
		delBt.setLocation(120,90);
		delBt.addActionListener(this);
		this.add(delBt);
		upBt=new JButton("修改");
		upBt.setSize(60, 30);
		upBt.setLocation(210,90);
		upBt.addActionListener(this);
		this.add(upBt);
		
		FlowerDAO dao=new FlowerDAO();
		ArrayList list=dao.findFlowerByfamily("");
		initTable(list);
		this.setVisible(true);
	}
	
	public void initTable(ArrayList<FlowerInfo> flowers)//初始化表格的方法
	{
		if((flowers!=null)||(flowers.size()!=0))
 		{
			if(panel!=null)
			{
				this.remove(panel);
			}
			String[] columnNames = { "花名", "别称", "所属科", "花期", "分布区域","形态特征" };
			String[][] values = new String[flowers.size()][6];
			for (int i = 0; i < flowers.size(); i++) {
				FlowerInfo flower = (FlowerInfo) flowers.get(i);
				values[i][0] = flower.getName();
				values[i][1] = flower.getOther_name();
				
				values[i][2] = flower.getFamily();
				values[i][3] = flower.getFlorescence();
				values[i][4] = flower.getDistribution();
				values[i][5] = flower.getCharacteristics();
				
			}
			table = new JTable(values, columnNames);
			panel = new JScrollPane(table);
			panel.setSize(750, 400);
			panel.setLocation(20, 150);
			this.add(panel);
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("所属科查找"))
		{
			FlowerDAO dao=new FlowerDAO();
			ArrayList list=dao.findFlowerByfamily(familyTxt.getText().trim());
			initTable(list);
		}
		else
		{
			if(bt.getText().equals("花名查找"))
			{
				FlowerDAO dao=new FlowerDAO();
				ArrayList list=new ArrayList();
				FlowerInfo flower=dao.findFlowerByName(nameTxt.getText().trim());
				if(flower!=null)
				{
					list.add(flower);
				}
				initTable(list);
			}
			else
			{
				if(bt.getText().equals("删除"))
				{
					if(table.getSelectedRow()==-1)
					{
						JOptionPane.showMessageDialog(this, "请选中要删除的花");
					}
					else
					{
						FlowerDAO dao = new FlowerDAO();
						dao.delFlower(table.getValueAt(table.getSelectedRow(),0).toString());
						ArrayList list = dao.findFlowerByfamily("");
						initTable(list);
					}
				}
				else
				{
					if(bt.getText().equals("修改"))
					{
						if(table.getSelectedRow()==-1)
						{
							JOptionPane.showMessageDialog(this, "请选中要修改的花");
						}
						else
						{
							int row = table.getSelectedRow();
							String name = table.getValueAt(row, 0).toString();
							String other_name = table.getValueAt(row, 1).toString();
							String family = table.getValueAt(row, 2).toString();
							String florescence=table.getValueAt(row, 3).toString();
							String distribution = table.getValueAt(row, 4).toString();
							String characteristics=table.getValueAt(row, 5).toString();
							FlowerInfo flower = new FlowerInfo(name, other_name, family,
									florescence,distribution,characteristics);
							AddOrUpdateFrame newFrame = new AddOrUpdateFrame(
									"修改", flower, this);
						}
					}
					else
					{
						AddOrUpdateFrame newFrame=new AddOrUpdateFrame(
								"增加",null,this);
					}
				}
			}
		}
	}

}
