package com.imooc.inetadderss;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * ����InetAddress��
 * @author Marie
 *
 */
public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		//��ȡ������InetAddressʵ��
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("���������"+address.getHostName());
		System.out.println("IP��ַ��"+address.getHostAddress());
		byte [] bytes = address.getAddress();//��ȡIP��ַ���ֽ�������ʽ
		System.out.println("�ֽ�������ʽ��IP��ַ��"+Arrays.toString(bytes));
		System.out.println(address);//ֱ�����InetAddress����
		
		//ͨ����������ȡInetAddressʵ��
//		InetAddress address2 = InetAddress.getByName("DESKTOP-ELTC4Q3");
		InetAddress address2 = InetAddress.getByName("10.111.48.244");
		System.out.println("���������"+address2.getHostName());
		System.out.println("IP��ַ��"+address2.getHostAddress());
		
	}

}
