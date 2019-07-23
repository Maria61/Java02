package com.iotek.decorator;
/**
 * 相当于BufferedInputStream
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
	//扩展的功能
	private void doThingB() {
		System.out.println("do B thing");
	}

}
