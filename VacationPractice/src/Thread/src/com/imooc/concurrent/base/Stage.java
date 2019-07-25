package com.imooc.concurrent.base;

/**
 * ���������Ϸ��̨
 * @author Marie
 *
 */
public class Stage extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Stage().start();
	}
	
	public void run() {
		System.out.println("��ӭ�ۿ��������壡");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("��Ļ����������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��˵�峯ĩ�꣬�����ũ���������ɱ�Ļ���ڵ�...");
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevilt = new ArmyRunnable();
		
		//ʹ��Runnable�ӿڴ����߳�
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"���");
		Thread armyOfRevilt = new Thread(armyTaskOfRevilt,"ũ�������");
		
		//�����߳�
		armyOfSuiDynasty.start();
		armyOfRevilt.start();
		
		//ʹ��̨�߳�����
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("����˫����ս��������·ɱ���˸���ҧ��");
		
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		System.out.println("��ҧ���������ǣ�����ս����ʹ�ϰ��չ��ϰ�����ҵ�����");
		
		//ͣս����
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevilt.keepRunning = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mrCheng.start();
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ս����������ҧ��ʵ�����������룬�ϰ��չ����˰�����ҵ�����");
		System.out.println("лл�ۿ����ݳ�������");
		
	
		
	}

}
