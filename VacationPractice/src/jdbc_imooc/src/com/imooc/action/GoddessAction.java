package com.imooc.action;
/**
 * 测试增删查改等方法
 */

import java.util.Date;
import java.util.List;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

public class GoddessAction {
	public static void main(String[] args) throws Exception {
		GoddessDao g = new GoddessDao();
		
		//遍历表格
//		List<Goddess> gs = g.query();
//		for(Goddess goddess:gs) {
//			System.out.println(goddess.getUser_name()+","+goddess.getAge());
//		}
//		
		//测试增加
//		Goddess g1 = new Goddess();
//		g1.setUser_name("小红");
//		g1.setAge(22);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("xioaxia@imooc.com");
//		g1.setMobile("12345678900");
//		g1.setCreate_user("ADMIN");
//		g1.setUpdate_user("ADMIN");
//		g1.setIsdel(1);
//		g.addGoddess(g1);
		
		//测试更新功能
//		Goddess g1 = new Goddess();
//		g1.setUser_name("小红");
//		g1.setAge(21);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("xioaxia@imooc.com");
//		g1.setMobile("12345699999");
//		g1.setUpdate_user("ADMIN22");
//		g1.setIsdel(1);
//		g1.setId(4);
//		g.updateGoddess(g1);
		
		//测试删除功能(按序号删除)
		g.delGoddess(4);
		
		//测试删除功能（按姓名删除）
		
		//测试查询（按姓名查询）
		
		//测试。。。
		
		//测试查询单个女神信息功能
		Goddess g2 = g.get(2);
		System.out.println(g2.toString());
		
	}
}
