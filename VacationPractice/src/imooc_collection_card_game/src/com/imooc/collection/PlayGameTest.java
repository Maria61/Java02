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
	String[] type = {"方块","梅花","红桃","黑桃"};//顺序固定，依次排序，黑桃等级最高
	
	public PlayGameTest() {
		this.cards = new ArrayList<Card>();
		this.players = new ArrayList<Player>();
	}
	
	/*
	 * 创建52张纸牌
	 */
	public void creatCards() {
		System.out.println("-------------创建纸牌------------");
		for(int i=0;i<13;i++) {
			for(int j=0;j<4;j++) {
				cards.add(new Card(type[j],num[i],i*13+j));
//				System.out.println("i="+i+"  ,"+"j="+j);
			}
		}
		System.out.println("-------------纸牌创建成功-------------");
		System.out.println("纸牌为：");
		for(int i=0;i<13;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(type[j]+num[i]+",");
			}
		}
		System.out.println("共52张纸牌");
	}
	/**
	 * 洗牌
	 */
	public void washCard() {
		System.out.println("----------开始洗牌----------");
		Collections.shuffle(cards);
		System.out.println("-----------洗牌结束----------");
	}
	/**
	 * 创建两名玩家
	 */
	public void creatPlayers() {
		System.out.println("-----------创建玩家-----------");
		System.out.println("请输入1号玩家的ID:");
		Scanner console = new Scanner(System.in);
		int id1 = console.nextInt();
		System.out.println("请输入姓名：");
		String name1 = console.next();
		p1 = new Player(id1,name1);
		players.add(p1);
		System.out.println("请输入2号玩家的ID:");
		int id2 = console.nextInt();
		System.out.println("请输入姓名：");
		String name2 = console.next();
		p2= new Player(id2,name2);
		players.add(p2);
		System.out.println("欢迎玩家："+p1.name);
		System.out.println("欢迎玩家："+p2.name);
	}
	/**
	 * 进行发牌
	 */
	public void distrubiteCard() {
		System.out.println("----------开始发牌----------");
		p1.pCards.add(cards.get(0));
		System.out.println("----玩家："+p1.name+"-拿牌------");
		p2.pCards.add(cards.get(1));
		System.out.println("----玩家："+p2.name+"-拿牌------");
		p1.pCards.add(cards.get(2));
		System.out.println("----玩家："+p1.name+"-拿牌------");
		p2.pCards.add(cards.get(3));
		System.out.println("----玩家："+p2.name+"-拿牌------");
		System.out.println("--------发牌结束-------");
	}
	/**
	 * 开始游戏
	 */
	public void playGame() {
		System.out.println("---------开始游戏---------");
		Collections.sort(p1.pCards);
		Collections.sort(p2.pCards);
		p1max = p1.pCards .get(1);
		p2max = p2.pCards .get(1);
		System.out.println("1号玩家的最大手牌为："+p1max.type+p1max.num);
		System.out.println("2号玩家的最大手牌为："+p2max.type+p2max.num);
		if(p1max.rank>p2max.rank) {
			System.out.println("--------1号玩家获胜："+p1.name+"-------------");
		}else {
			System.out.println("--------2号玩家获胜："+p2.name+"-------------");
		}
		System.out.println("-----------玩家各自的手牌为-----------");
		p1min = p1.pCards.get(0);
		p2min = p2.pCards.get(0);
		 System.out.println(p1.name+":"+p1max.type+p1max.num+","+p1min.type+p1min.num);
		 System.out.println(p2.name+":"+p2max.type+p2max.num+","+p2min.type+p2min.num);
		 System.out.println("----------------游戏结束---------------");
	}
	
	
	
	/**
	 * 玩游戏
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
