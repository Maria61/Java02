package com.imooc.action;
/**
 * ������ɾ��ĵȷ���
 */

import java.util.Date;
/**
 * ��ɾ��ĵȷ����ĵ��ã�
 */
import java.util.List;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

public class GoddessAction {
	public static void main(String[] args) throws Exception {
		GoddessDao g = new GoddessDao();
		
		//�������
//		List<Goddess> gs = g.query();
//		for(Goddess goddess:gs) {
//			System.out.println(goddess.getUser_name()+","+goddess.getAge());
//		}
//		
		//��������
//		Goddess g1 = new Goddess();
//		g1.setUser_name("С��");
//		g1.setAge(22);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("xioaxia@imooc.com");
//		g1.setMobile("12345678900");
//		g1.setCreate_user("ADMIN");
//		g1.setUpdate_user("ADMIN");
//		g1.setIsdel(1);
//		g.addGoddess(g1);
		
		//���Ը��¹���
//		Goddess g1 = new Goddess();
//		g1.setUser_name("С��");
//		g1.setAge(21);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("xioaxia@imooc.com");
//		g1.setMobile("12345699999");
//		g1.setUpdate_user("ADMIN22");
//		g1.setIsdel(1);
//		g1.setId(4);
//		g.updateGoddess(g1);
		
		//����ɾ������
		g.delGoddess(4);
		
		//���Բ�ѯ����Ů����Ϣ����
		Goddess g2 = g.get(2);
		System.out.println(g2.toString());
		
	}
}
