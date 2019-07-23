package com.iotek.decorator;
/**
 * 类似于包装类FlterInputStream
 * @author Marie
 *
 */
public class Decorator implements component {
	private com.iotek.decorator.component component = null;
	
	public Decorator(com.iotek.decorator.component component) {
		this.component = component;
	}
	
	@Override
	public void doThingA() {
		// TODO Auto-generated method stub
		component.doThingA();//调用被装饰对象的方法
	}

}
