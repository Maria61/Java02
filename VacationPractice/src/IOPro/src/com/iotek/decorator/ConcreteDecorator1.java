package com.iotek.decorator;
/**
 * �൱��BufferedInputStream
 * @author Marie
 *
 */
public class ConcreteDecorator1 extends Decorator {

	public ConcreteDecorator1(com.iotek.decorator.component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doThingA(){
		super.doThingA();
		doThingB();
	}
	//��չ�Ĺ���
	private void doThingB() {
		System.out.println("do B thing");
	}

}
