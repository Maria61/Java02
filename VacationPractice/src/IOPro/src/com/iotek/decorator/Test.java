package com.iotek.decorator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcerteComponent component = new ConcerteComponent();
//		component.doThingA();
		ConcreteDecorator1 decorator = new ConcreteDecorator1(component);
//		decorator.doThingA();
		ConcreteDecorator1 decorator2 = new ConcreteDecorator1(decorator);
		decorator2.doThingA();
	}

}
