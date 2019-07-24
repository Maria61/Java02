package com.imooc.inetadderss;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 关于URL类的常用方法测试
 * @author Marie
 *
 */
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//创建一个URL实例
			URL imooc = new URL("http://www.imooc.com");
			
			//?后边表示参数，#后面表示锚点
			URL url = new URL(imooc,"/index.html?username = Tom#test");
			
			System.out.println("协议为："+url.getProtocol());
			System.out.println("主机为："+url.getHost());
			//通过getPort()方法获取端口，如果没有指定端口号，将使用默认的端口号，此时getPort()方法返回值为-1
			System.out.println("端口为："+url.getPort());//-1
			System.out.println("文件路径："+url.getPath());//  /index.html
			System.out.println("文件名："+url.getFile());//   文件路径?参数
			System.out.println("相对路径："+url.getRef());//  锚点
			System.out.println("查询字符串："+url.getQuery());//  参数
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
