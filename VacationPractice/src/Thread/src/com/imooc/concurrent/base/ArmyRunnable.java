package com.imooc.concurrent.base;
/**
 * �����̣߳�ģ��˫������ս��Ϊ
 * @author Marie
 *
 */
public class ArmyRunnable implements Runnable {

	volatile boolean keepRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(keepRunning) {
			//����������
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"����["+i+"]");
				Thread.yield();//�ó�������ʱ�䣬��ƽ����
			}
		}
		System.out.println(Thread.currentThread().getName()+"��������");
	}

}
