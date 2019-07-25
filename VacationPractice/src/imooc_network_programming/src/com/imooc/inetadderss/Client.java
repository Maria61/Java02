package com.imooc.inetadderss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * @author Marie
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			//1.�����ͻ��ˣ�ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("localhost",2345);
			
			//2.��ȡ���������������˷�����Ϣ
			OutputStream os = socket.getOutputStream();//�ֽ���
			PrintWriter pw = new PrintWriter(os);//���������װΪ��ӡ��
			pw.write("�û�����tom;���룺456");
			pw.flush();
			socket.shutdownOutput();//�ر������
			
			//3.��ȡ������������ȡ����˵���Ӧ��Ϣ
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = br.readLine())!=null) {//ѭ����ȡ�ͻ�����Ϣ
				System.out.println("���ǿͻ��ˣ���������˵��"+info);
			}
	
			//4.�ر���Դ
			is.close();
			br.close();
			pw.close();
			os.close();
			socket.close();
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
