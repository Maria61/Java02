package com.imooc.inetadderss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket socket = null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	//�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			
			//ʵ�ֿͻ��˺ͷ������˵Ľ�������ȡ������������ȡ�ͻ�����Ϣ
			is = socket.getInputStream();
			isr = new InputStreamReader(is);//���ֽ���ת��Ϊ�ַ���
			br =new BufferedReader(isr);//��ӻ�����
			String info = null;
			while((info = br.readLine())!=null) {//ѭ����ȡ�ͻ�����Ϣ
				System.out.println("���Ƿ������ˣ��ͻ���˵��"+info);
			}
			socket.shutdownInput();//�ر�������
			//��ȡ���������Ӧ�ͻ��˵�����
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("��ӭ����");
			pw.flush();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//�ر���Դ
				if(pw!=null) 
					pw.close();
				if(os!=null)
					os.close();
				if(is!=null)
					is.close();
				if(br!=null)
					br.close();
				if(isr!=null)
					isr.close();
				if(socket!=null)
					socket.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
}
