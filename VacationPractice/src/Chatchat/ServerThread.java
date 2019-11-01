
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread {
	Socket socket = null;
	BufferedReader br = null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	//线程执行的操作，响应客户端的请求
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//实现客户端和服务器端的交互，获取输入流，并读取客户端信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is,"UTF-8");//将字节流转化为字符流
			br =new BufferedReader(isr);//添加缓冲区
			
			
			while(true) {
				
				String info = null;
				while((info = readClient())!=null) {//循环读取客户端信息

					for(Socket s:Server.socketList) {
						System.out.println("---------------");
						os = s.getOutputStream();
						pw = new PrintWriter(os);
						System.out.println(info);
						pw.println(info);
						System.out.println("已转发！");
						pw.flush();
					}
				}
			}
			
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
	
	private String readClient() {
		try {
			return br.readLine();
		} catch (IOException e) {
			Server.socketList.remove(socket);//如果捕获到异常，说明该客户端出现问题，则将该客户端移除集合
		}
		return null;
	}
}
