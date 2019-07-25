package com.imooc.tickets_demo;

/**
 * 用Thream实现卖票
 * @author Marie
 *
 */

class MyThread extends Thread{
	private String name;
	private int ticketsCout = 5;
	
	public MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		while(ticketsCout>0) {
			ticketsCout--;
			System.out.println(name+"卖了一张票，还剩"+ticketsCout);
		}
		
	}
	
	
}
public class TicketsThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建三个线程进行卖票
		MyThread mt1 = new MyThread("窗口1");
		MyThread mt2 = new MyThread("窗口2");
		MyThread mt3 = new MyThread("窗口3");
		
		//开始执行线程
		mt1.start();
		mt2.start();
		mt3.start();
	}

}
