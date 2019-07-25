package com.imooc.inetadderss;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * �ͻ���
 * @author Marie
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		/**
		 * �����˷�����Ϣ
		 */
		
		//1.����IP��ַ���˿ںţ����ݰ�
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] bytes = "�û�����admin;���룺123".getBytes();
		//2.�������ݱ�������������������Ϣ
		DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,port);
		
		//3.����DatagramSocket����
		DatagramSocket socket = new DatagramSocket();
		//��������˷�������
		socket.send(packet);
		
		/**
		 * ���շ���˵���Ӧ
		 */
		//1.�������ݱ������ڽ��շ�������������Ϣ
		byte[] bytes2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(bytes2,bytes2.length);
		//2.����������Ϣ
		socket.receive(packet2);
		//3.��ȡ������Ϣ
		String info = new String(bytes2,0,packet2.getLength());
		System.out.println("���ǿͻ��ˣ���������˵��"+info);
		//4.�ر���Դ
		socket.close();
		
		
	}

}
