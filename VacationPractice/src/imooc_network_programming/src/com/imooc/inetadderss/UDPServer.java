package com.imooc.inetadderss;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * �������ˣ����ڻ���UDP���û���¼
 * @author Marie
 *
 */

public class UDPServer {

	public static void main(String[] args) throws IOException {
		/**
		 * ���տͻ��˷��͵�����
		 */
		//1.�����������˿�DatagramSocket,�ƶ��˿ں�
		DatagramSocket socket = new DatagramSocket(8800);
		//2.�������ݱ������ڽ��տͻ�������
		byte[] bytes = new byte[1024];//�����ֽ����飬ָ�����յ����ݰ��Ĵ�С
		DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
		//3.���տͻ�������
		System.out.println("***���������Ѿ��������ȴ��ͻ��˵�����***");
		socket.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ��һֱ����
		//��ȡ����
		String info = new String(bytes,0,bytes.length);
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		/**
		 * ��ͻ��˷�����Ӧ
		 */
		//1.����ͻ��˵�IP��ַ���˿ںţ�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] bytes2 = "��ӭ��".getBytes();
		//2.�������ݱ�������������������Ϣ
		DatagramPacket packet2 = new DatagramPacket(bytes2,bytes2.length,address,port);
		//3.��������
		socket.send(packet2);
		//4.�ر���Դ��Ϣ
		socket.close();
	}

}
