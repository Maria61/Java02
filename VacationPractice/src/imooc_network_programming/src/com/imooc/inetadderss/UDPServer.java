package com.imooc.inetadderss;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * 服务器端，用于基于UDP的用户登录
 * @author Marie
 *
 */

public class UDPServer {

	public static void main(String[] args) throws IOException {
		/**
		 * 接收客户端发送的数据
		 */
		//1.创建服务器端口DatagramSocket,制定端口号
		DatagramSocket socket = new DatagramSocket(8800);
		//2.创建数据报，用于接收客户端数据
		byte[] bytes = new byte[1024];//创建字节数组，指定接收的数据包的大小
		DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
		//3.接收客户端数据
		System.out.println("***服务器端已经启动，等待客户端的连接***");
		socket.receive(packet);//此方法在接收到数据报之前会一直堵塞
		//读取数据
		String info = new String(bytes,0,bytes.length);
		System.out.println("我是服务器，客户端说："+info);
		/**
		 * 向客户端发出响应
		 */
		//1.定义客户端的IP地址，端口号，数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] bytes2 = "欢迎您".getBytes();
		//2.创建数据报，包含发出的数据信息
		DatagramPacket packet2 = new DatagramPacket(bytes2,bytes2.length,address,port);
		//3.发送数据
		socket.send(packet2);
		//4.关闭资源信息
		socket.close();
	}

}
