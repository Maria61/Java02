package com.iotek.decorator;
/**
 * �൱��BufferedInputStream
 * @author Marie
 *
 */
public class ConcreteDecorator2 extends Decorator {

	public ConcreteDecorator2(com.iotek.decorator.component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doThingA(){
		super.doThingA();
		doThingC();
	}
	//��չ�Ĺ���
	private void doThingC() {
		System.out.println("do C thing");
	}

}
