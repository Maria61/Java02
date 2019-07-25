package com.imooc.concurrent.base;

/**
 * 隋唐演义大戏舞台
 * @author Marie
 *
 */
public class Stage extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Stage().start();
	}
	
	public void run() {
		System.out.println("欢迎观看隋唐演义！");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("大幕徐徐拉开！");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("话说隋朝末年，隋军与农民起义军厮杀的昏天黑地...");
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevilt = new ArmyRunnable();
		
		//使用Runnable接口创建线程
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread armyOfRevilt = new Thread(armyTaskOfRevilt,"农民起义军");
		
		//启动线程
		armyOfSuiDynasty.start();
		armyOfRevilt.start();
		
		//使舞台线程休眠
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("正当双方激战正酣，半路杀出了个程咬金！");
		
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("程咬金的理想就是：结束战争，使老百姓过上安居乐业的生活！");
		
		//停战命令
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
		
		System.out.println("战争结束，程咬金实现了他的理想，老百姓过上了安居乐业的生活！");
		System.out.println("谢谢观看，演出结束！");
		
	
		
	}

}
