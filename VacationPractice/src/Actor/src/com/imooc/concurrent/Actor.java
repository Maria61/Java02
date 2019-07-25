package com.imooc.concurrent;

public class Actor extends Thread {//����һ���µ�ִ���̷߳���һ���̳�Thread����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		
		Thread actressThread = new Thread(new Actress(),"Ms.Runnable");
		actressThread.start();
	}
	
	public void run() {
		System.out.println(getName()+"��һ����Ա");
		int count = 0;
		boolean keepRuning = true;
		while(keepRuning) {
			System.out.println(getName()+"��̨�ݳ�"+(++count));
			if(count == 100) {
				keepRuning = false;
			}
			if(count%10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		System.out.println(getName()+"�ݳ���������");
	}

}

class Actress implements Runnable{//�����µ�ִ���̷߳�������ʵ��Runnable�ӿ�

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"��һ����Ա");
		int count = 0;
		boolean keepRuning = true;
		while(keepRuning) {
			System.out.println(Thread.currentThread().getName()+"��̨�ݳ�"+(++count));
			if(count == 100) {
				keepRuning = false;
			}
			if(count%10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		System.out.println(Thread.currentThread().getName()+"�ݳ���������");
	}
	
}
