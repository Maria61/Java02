package com.imooc.collection;
/**
 * ÷Ω≈∆¿‡
 * @author Marie
 *
 */
public class Card implements Comparable<Card>{
	String num;
	String type;
	int rank;
	
	public Card(String type,String num,int rank) {
		this.num = num;
		this.type = type;
		this.rank = rank;
	}
	public Card() {
	}
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return this.rank-o.rank;
	}
}
