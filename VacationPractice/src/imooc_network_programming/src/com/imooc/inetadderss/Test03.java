package com.imooc.inetadderss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ʹ��URL��ȡ��ҳ����
 * @author Marie
 *
 */
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//����һ��URLʵ��
			URL url = new URL("http://www.baidu.com");
			//ͨ��URL��inputStream����ȥ��ȡURL�Ķ����ʾ����Դ���ֽ�������
			InputStream is = url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//Ϊ�ַ���������ӻ�����
			BufferedReader br = new BufferedReader(isr);
			//��ȡ����
			String data = br.readLine();
			while(data!=null) {//ѭ����ȡ����
				System.out.println(data);
				data = br.readLine();
			}
			br.close();
			isr.close();
			is.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
