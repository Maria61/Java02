package com.imooc.inetadderss;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ����URL��ĳ��÷�������
 * @author Marie
 *
 */
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//����һ��URLʵ��
			URL imooc = new URL("http://www.imooc.com");
			
			//?��߱�ʾ������#�����ʾê��
			URL url = new URL(imooc,"/index.html?username = Tom#test");
			
			System.out.println("Э��Ϊ��"+url.getProtocol());
			System.out.println("����Ϊ��"+url.getHost());
			//ͨ��getPort()������ȡ�˿ڣ����û��ָ���˿ںţ���ʹ��Ĭ�ϵĶ˿ںţ���ʱgetPort()��������ֵΪ-1
			System.out.println("�˿�Ϊ��"+url.getPort());//-1
			System.out.println("�ļ�·����"+url.getPath());//  /index.html
			System.out.println("�ļ�����"+url.getFile());//   �ļ�·��?����
			System.out.println("���·����"+url.getRef());//  ê��
			System.out.println("��ѯ�ַ�����"+url.getQuery());//  ����
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
