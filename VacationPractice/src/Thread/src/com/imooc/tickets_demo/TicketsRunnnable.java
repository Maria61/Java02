package com.imooc.tickets_demo;
/**
 * ͨ��Runnableʵ�ֶ��߳���Ʊ
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
			System.out.println(Thread.currentThread().getName()+"����1��Ʊ��ʣ��Ʊ��Ϊ��"+ticketsCout);
			
		}
		
	}
	
}

public class TicketsRunnnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable mb = new MyRunnable();
		
		Thread td1 = new Thread(mb,"����1");
		Thread td2 = new Thread(mb,"����2");
		Thread td3 = new Thread(mb,"����3");
		
		td1.start();
		td2.start();
		td3.start();
	}

}
