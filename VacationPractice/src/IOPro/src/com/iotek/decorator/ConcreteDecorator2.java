package com.iotek.decorator;
/**
 * 相当于BufferedInputStream
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
	//扩展的功能
	private void doThingC() {
		System.out.println("do C thing");
	}

}
