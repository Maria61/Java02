package com.imooc.inetadderss;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 关于InetAddress类
 * @author Marie
 *
 */
public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		//获取本机的InetAddress实例
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("计算机名："+address.getHostName());
		System.out.println("IP地址："+address.getHostAddress());
		byte [] bytes = address.getAddress();//获取IP地址的字节数组形式
		System.out.println("字节数组形式的IP地址："+Arrays.toString(bytes));
		System.out.println(address);//直接输出InetAddress对象
		
		//通过计器名获取InetAddress实例
//		InetAddress address2 = InetAddress.getByName("DESKTOP-ELTC4Q3");
		InetAddress address2 = InetAddress.getByName("10.111.48.244");
		System.out.println("计算机名："+address2.getHostName());
		System.out.println("IP地址："+address2.getHostAddress());
		
	}

}
