package com.imooc.tickets_demo;
/**
 * 通过Runnable实现多线程卖票
 * @author Marie
 *
 */
class MyRunnable implements Runnable{
	private int ticketsCout = 5;
	
	@Override
	public  synchronized void run() {
		// TODO Auto-generated method stub
		while(ticketsCout>0) {
			ticketsCout--;
//			System.out.println(ticketsCout);
			System.out.println(Thread.currentThread().getName()+"卖了1张票，剩余票数为："+ticketsCout);
			
		}
		
	}
	
}

public class TicketsRunnnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable mb = new MyRunnable();
		
		Thread td1 = new Thread(mb,"窗口1");
		Thread td2 = new Thread(mb,"窗口2");
		Thread td3 = new Thread(mb,"窗口3");
		
		td1.start();
		td2.start();
		td3.start();
	}

}
