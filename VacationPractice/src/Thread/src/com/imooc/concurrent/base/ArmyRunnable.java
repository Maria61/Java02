package com.imooc.concurrent.base;
/**
 * 军队线程，模拟双方的作战行为
 * @author Marie
 *
 */
public class ArmyRunnable implements Runnable {

	volatile boolean keepRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(keepRunning) {
			//发动五连击
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"进击["+i+"]");
				Thread.yield();//让出处理器时间，公平竞争
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束进击");
	}

}
