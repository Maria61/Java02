package com.imooc.tickets_demo;

/**
 * ��Threamʵ����Ʊ
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
			System.out.println(name+"����һ��Ʊ����ʣ"+ticketsCout);
		}
		
	}
	
	
}
public class TicketsThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������߳̽�����Ʊ
		MyThread mt1 = new MyThread("����1");
		MyThread mt2 = new MyThread("����2");
		MyThread mt3 = new MyThread("����3");
		
		//��ʼִ���߳�
		mt1.start();
		mt2.start();
		mt3.start();
	}

}
