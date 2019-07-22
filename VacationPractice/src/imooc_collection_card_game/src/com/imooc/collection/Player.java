package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ÕÊº“¿‡
 * @author Marie
 *
 */
public class Player {
	int id;
	String name;
	List<Card> pCards;
	
	public Player(int id,String name) {
		this.id = id;
		this.name =name;
		this.pCards = new ArrayList<Card>();
	}
	
}
