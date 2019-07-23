package com.fehead;

public class FactorialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FacUtil.getFac(5));
	}

}
class FacUtil{
	public static int getFac(int num) {
		if(num == 1) {
			return 1;
		}else {
			return num*getFac(num-1);
		}
	}
}
