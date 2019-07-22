package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayGameTest {
	List<Card>cards;
	List<Player>players;
	Player p1;
	Player p2;
	Card p1max;
	Card p2max;
	Card p1min;
	Card p2min;
	
	String[] num = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	String[] type = {"����","÷��","����","����"};//˳��̶����������򣬺��ҵȼ����
	
	public PlayGameTest() {
		this.cards = new ArrayList<Card>();
		this.players = new ArrayList<Player>();
	}
	
	/*
	 * ����52��ֽ��
	 */
	public void creatCards() {
		System.out.println("-------------����ֽ��------------");
		for(int i=0;i<13;i++) {
			for(int j=0;j<4;j++) {
				cards.add(new Card(type[j],num[i],i*13+j));
//				System.out.println("i="+i+"  ,"+"j="+j);
			}
		}
		System.out.println("-------------ֽ�ƴ����ɹ�-------------");
		System.out.println("ֽ��Ϊ��");
		for(int i=0;i<13;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(type[j]+num[i]+",");
			}
		}
		System.out.println("��52��ֽ��");
	}
	/**
	 * ϴ��
	 */
	public void washCard() {
		System.out.println("----------��ʼϴ��----------");
		Collections.shuffle(cards);
		System.out.println("-----------ϴ�ƽ���----------");
	}
	/**
	 * �����������
	 */
	public void creatPlayers() {
		System.out.println("-----------�������-----------");
		System.out.println("������1����ҵ�ID:");
		Scanner console = new Scanner(System.in);
		int id1 = console.nextInt();
		System.out.println("������������");
		String name1 = console.next();
		p1 = new Player(id1,name1);
		players.add(p1);
		System.out.println("������2����ҵ�ID:");
		int id2 = console.nextInt();
		System.out.println("������������");
		String name2 = console.next();
		p2= new Player(id2,name2);
		players.add(p2);
		System.out.println("��ӭ��ң�"+p1.name);
		System.out.println("��ӭ��ң�"+p2.name);
	}
	/**
	 * ���з���
	 */
	public void distrubiteCard() {
		System.out.println("----------��ʼ����----------");
		p1.pCards.add(cards.get(0));
		System.out.println("----��ң�"+p1.name+"-����------");
		p2.pCards.add(cards.get(1));
		System.out.println("----��ң�"+p2.name+"-����------");
		p1.pCards.add(cards.get(2));
		System.out.println("----��ң�"+p1.name+"-����------");
		p2.pCards.add(cards.get(3));
		System.out.println("----��ң�"+p2.name+"-����------");
		System.out.println("--------���ƽ���-------");
	}
	/**
	 * ��ʼ��Ϸ
	 */
	public void playGame() {
		System.out.println("---------��ʼ��Ϸ---------");
		Collections.sort(p1.pCards);
		Collections.sort(p2.pCards);
		p1max = p1.pCards .get(1);
		p2max = p2.pCards .get(1);
		System.out.println("1����ҵ��������Ϊ��"+p1max.type+p1max.num);
		System.out.println("2����ҵ��������Ϊ��"+p2max.type+p2max.num);
		if(p1max.rank>p2max.rank) {
			System.out.println("--------1����һ�ʤ��"+p1.name+"-------------");
		}else {
			System.out.println("--------2����һ�ʤ��"+p2.name+"-------------");
		}
		System.out.println("-----------��Ҹ��Ե�����Ϊ-----------");
		p1min = p1.pCards.get(0);
		p2min = p2.pCards.get(0);
		 System.out.println(p1.name+":"+p1max.type+p1max.num+","+p1min.type+p1min.num);
		 System.out.println(p2.name+":"+p2max.type+p2max.num+","+p2min.type+p2min.num);
		 System.out.println("----------------��Ϸ����---------------");
	}
	
	
	
	/**
	 * ����Ϸ
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayGameTest pgt = new PlayGameTest();
		pgt.creatCards();
		pgt.washCard();
		pgt.creatPlayers();
		pgt.distrubiteCard();
		pgt.playGame();
	}

}
