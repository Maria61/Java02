package com.imooc.inetadderss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL读取网页内容
 * @author Marie
 *
 */
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//创建一个URL实例
			URL url = new URL("http://www.baidu.com");
			//通过URL的inputStream方法去获取URL的对象表示的资源的字节输入流
			InputStream is = url.openStream();
			//将字节输入流转化为字符输入流
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//为字符输入流添加缓冲区
			BufferedReader br = new BufferedReader(isr);
			//读取数据
			String data = br.readLine();
			while(data!=null) {//循环读取数据
				System.out.println(data);
				data = br.readLine();
			}
			br.close();
			isr.close();
			is.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
