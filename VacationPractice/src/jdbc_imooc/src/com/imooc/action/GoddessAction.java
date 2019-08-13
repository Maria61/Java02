package com.imooc.action;
/**
 * 控制层
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/**
 * 增删查改等方法的调用！
 */
import java.util.List;
import java.util.Map;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

public class GoddessAction {
	public static void main(String[] args) throws Exception {
		GoddessDao g = new GoddessDao();
		
//		遍历表格
//		List<Goddess> gs = g.query();
//		for(Goddess goddess:gs) {
//			System.out.println(goddess.getUser_name()+","+goddess.getAge());
//		}
		
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
		Goddess g1 = new Goddess();
		g1.setUser_name("小红");
		g1.setAge(21);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("xioaxia@imooc.com");
		g1.setMobile("12345699999");
		g1.setUpdate_user("ADMIN22");
		g1.setIsdel(1);
		g1.setId(4);
		g.updateGoddess(g1);
		
//		//测试删除功能
//		g.delGoddess(4);
//		
//		//测试查询单个女神信息功能
//		Goddess g2 = g.get(2);
//		System.out.println(g2.toString());
		
		//多个条件查询
//		List<Goddess> gs = g.query("小红","0");
//		for(Goddess goddess:gs) {
//			System.out.println(goddess.toString());
//		}
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("name","user_name");
		param.put("rela","like");
		param.put("value","'%小%'");
		params.add(param);
		param = new HashMap<String,Object>();
		param.put("name","mobile");
		param.put("rela","=");
		param.put("value","'12345678900'");
		params.add(param);
		List<Goddess> gs = g.query(params);
		for(Goddess goddess:gs) {
			System.out.println(goddess.toString());
		}
	}
}
