package com.iotek.decorator;
/**
 * �����ڰ�װ��FlterInputStream
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
		component.doThingA();//���ñ�װ�ζ���ķ���
	}

}
