package com.imooc.inetadderss;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * 客户端
 * @author Marie
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		/**
		 * 向服务端发送信息
		 */
		
		//1.定义IP地址，端口号，数据包
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] bytes = "用户名：admin;密码：123".getBytes();
		//2.创建数据报，包含发出的数据信息
		DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,port);
		
		//3.创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();
		//向服务器端发送数据
		socket.send(packet);
		
		/**
		 * 接收服务端的响应
		 */
		//1.创建数据报，用于接收服务器端数据信息
		byte[] bytes2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(bytes2,bytes2.length);
		//2.接收数据信息
		socket.receive(packet2);
		//3.读取数据信息
		String info = new String(bytes2,0,packet2.getLength());
		System.out.println("我是客户端，服务器端说："+info);
		//4.关闭资源
		socket.close();
		
		
	}

}
