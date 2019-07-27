package com.imooc.inetadderss;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于TCP协议的Socket通信,实现用户登录
 * 服务器端
 * @author Marie
 *
 */
public class Server {
	public static List<Socket> socketList = new ArrayList<Socket>();
	
	public static void main(String[] args) {
		
		try {
			
			//1.创建一个服务器端Socket,即ServerSocket,指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(2345);//指定1023往后的端口
			Socket socket = null;
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端的链接***");
			//循环监听，等待客户端的连接
			while(true) {
				socket = serverSocket.accept();//调用此方法后，服务器处于阻塞的状态，等待客户端的侦听
				socketList.add(socket);
				count++;
				System.out.println("客户端的数量："+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("客户端IP地址："+address.getHostAddress());
			
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				
				
	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
