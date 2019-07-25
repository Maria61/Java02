package com.imooc.concurrent.base;

public class KeyPersonThread extends Thread {

	
	public void run() {
		System.out.println(Thread.currentThread().getName()+"¿ªÊ¼Õ½¶·À²£¡");
		
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"×óÍ»ÓÒÉ±£¬¹¥»÷Ëå¾ü£¡");
		}
		System.out.println(Thread.currentThread().getName()+"½áÊøÕ½¶·À²£¡");
	}
}
