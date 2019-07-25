package com.imooc.concurrent;

public class Actor extends Thread {//创建一个新的执行线程方法一：继承Thread父类

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		
		Thread actressThread = new Thread(new Actress(),"Ms.Runnable");
		actressThread.start();
	}
	
	public void run() {
		System.out.println(getName()+"是一个演员");
		int count = 0;
		boolean keepRuning = true;
		while(keepRuning) {
			System.out.println(getName()+"登台演出"+(++count));
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
		
		
		System.out.println(getName()+"演出结束啦！");
	}

}

class Actress implements Runnable{//创建新的执行线程方法二：实现Runnable接口

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"是一个演员");
		int count = 0;
		boolean keepRuning = true;
		while(keepRuning) {
			System.out.println(Thread.currentThread().getName()+"登台演出"+(++count));
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
		
		
		System.out.println(Thread.currentThread().getName()+"演出结束啦！");
	}
	
}
