package flowerproject.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class AddOrUpdateFrame extends JFrame implements ActionListener{
	JLabel nameLa,familyLa,sexLa,ageLa,deptLa,other_nameLa,florescenceLa,distributionLa,characteristicsLa;
	JTextField nameTxt,familyTxt,ageTxt,other_nameTxt,distributionTxt,characteristicsTxt;
	JComboBox sexCom,deptCom,florescenceCom;
	JButton bt;
	MainFrame main;//定义主窗口
	
	public AddOrUpdateFrame(String type,FlowerInfo flower,MainFrame main)
	{
		this.setSize(300,400);
		this.setLayout(null);
		nameLa=new JLabel("花名");
		nameLa.setSize(60, 30);
		nameLa.setLocation(30, 30);
		this.add(nameLa);
		
		nameTxt=new JTextField();
		nameTxt.setSize(120, 30);
		nameTxt.setLocation(100, 30);
		this.add(nameTxt);
		
		other_nameLa=new JLabel("别称");
		other_nameLa.setSize(60,30);
		other_nameLa.setLocation(30,80);
		this.add(other_nameLa);
		
		other_nameTxt=new JTextField();
		other_nameTxt.setSize(120,30);
		other_nameTxt.setLocation(100,80);
		this.add(other_nameTxt);
				
		familyLa=new JLabel("所属科");
		familyLa.setSize(60, 30);
		familyLa.setLocation(30, 130);
		this.add(familyLa);
		
		familyTxt=new JTextField();
		familyTxt.setSize(120, 30);
		familyTxt.setLocation(100, 130);
		this.add(familyTxt);
		
		
		florescenceLa=new JLabel("花期");
		florescenceLa.setSize(60, 30);
		florescenceLa.setLocation(30, 180);
		this.add(florescenceLa);
		
		florescenceCom=new JComboBox();
		florescenceCom.setSize(120, 30);
		florescenceCom.setLocation(100,180);
		florescenceCom.addItem("一月");
		florescenceCom.addItem("二月");
		florescenceCom.addItem("三月");
		florescenceCom.addItem("四月");
		florescenceCom.addItem("五月");
		florescenceCom.addItem("六月");
		florescenceCom.addItem("七月");
		florescenceCom.addItem("八月");
		florescenceCom.addItem("九月");
		florescenceCom.addItem("十月");
		florescenceCom.addItem("十一月");
		florescenceCom.addItem("十二月");
		this.add(florescenceCom);
		
		distributionLa=new JLabel("分布地区");
		distributionLa.setSize(60, 30);
		distributionLa.setLocation(30, 230);
		this.add(distributionLa);
		
		distributionTxt=new JTextField();
		distributionTxt.setSize(120, 30);
		distributionTxt.setLocation(100, 230);
		this.add(distributionTxt);
		
		characteristicsLa=new JLabel("形态特征");
		characteristicsLa.setSize(60, 30);
		characteristicsLa.setLocation(30, 280);
		this.add(characteristicsLa);
		
		characteristicsTxt=new JTextField();
		characteristicsTxt.setSize(120, 30);
		characteristicsTxt.setLocation(100, 280);
		this.add(characteristicsTxt);
		
		
		if(type.equals("增加"))
		{
			this.setTitle("增加");
			bt=new JButton("增加");
			bt.setSize(60, 30);
			bt.setLocation(90,330);
		}
		else
		{
			this.setTitle("修改");
			bt=new JButton("修改");
			bt.setSize(60, 30);
			bt.setLocation(90,330);
			if(flower!=null)
			{
				nameTxt.setText(flower.getName());
				nameTxt.setEditable(false);
				other_nameTxt.setText(flower.getOther_name());
				familyTxt.setText(flower.getFamily());
				florescenceCom.setSelectedItem(flower.getFlorescence());
				distributionTxt.setText(flower.getDistribution());
				characteristicsTxt.setText(flower.getCharacteristics());
				
			}
		}
		this.add(bt);
		bt.addActionListener(this);
		this.setVisible(true);
		this.main=main;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton bt=(JButton)e.getSource();
		FlowerDAO dao=new FlowerDAO();
		String name=nameTxt.getText().trim();
		String family=familyTxt.getText().trim();
		String other_name=other_nameTxt.getText().trim();
		String florescence=florescenceCom.getSelectedItem().toString();
		String distribution=distributionTxt.getText().trim();
		String characteristics=characteristicsTxt.getText().trim();
		FlowerInfo flower=new FlowerInfo(name,other_name,family,florescence,distribution,characteristics);
		if(bt.getText().equals("修改"))
		{
			dao.updateFlower(flower);
		}
		else
		{
			dao.addFlower(flower);
		}
		ArrayList list=dao.findFlowerByfamily("");
		main.initTable(list);
		this.dispose();
		
	}
}
