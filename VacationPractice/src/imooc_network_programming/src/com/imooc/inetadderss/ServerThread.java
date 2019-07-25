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
	//线程执行的操作，响应客户端的请求
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			
			//实现客户端和服务器端的交互，获取输入流，并读取客户端信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is);//将字节流转化为字符流
			br =new BufferedReader(isr);//添加缓冲区
			String info = null;
			while((info = br.readLine())!=null) {//循环读取客户端信息
				System.out.println("我是服务器端，客户端说："+info);
			}
			socket.shutdownInput();//关闭输入流
			//获取输出流，响应客户端的请求
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//关闭资源
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
