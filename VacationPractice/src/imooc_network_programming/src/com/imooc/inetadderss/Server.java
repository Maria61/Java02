package com.imooc.inetadderss;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ���Socketͨ��,ʵ���û���¼
 * ��������
 * @author Marie
 *
 */
public class Server {
	public static void main(String[] args) {
		
		try {
			
			//1.����һ����������Socket,��ServerSocket,ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket = new ServerSocket(2345);//ָ��1023����Ķ˿�
			Socket socket = null;
			int count = 0;
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			//ѭ���������ȴ��ͻ��˵�����
			while(true) {
				socket = serverSocket.accept();//���ô˷����󣬷���������������״̬���ȴ��ͻ��˵�����
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				count++;
				System.out.println("�ͻ��˵�������"+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("�ͻ���IP��ַ��"+address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
