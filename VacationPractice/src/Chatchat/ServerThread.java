
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
	//�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//ʵ�ֿͻ��˺ͷ������˵Ľ�������ȡ������������ȡ�ͻ�����Ϣ
			is = socket.getInputStream();
			isr = new InputStreamReader(is,"UTF-8");//���ֽ���ת��Ϊ�ַ���
			br =new BufferedReader(isr);//��ӻ�����
			
			
			while(true) {
				
				String info = null;
				while((info = readClient())!=null) {//ѭ����ȡ�ͻ�����Ϣ

					for(Socket s:Server.socketList) {
						System.out.println("---------------");
						os = s.getOutputStream();
						pw = new PrintWriter(os);
						System.out.println(info);
						pw.println(info);
						System.out.println("��ת����");
						pw.flush();
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//�ر���Դ
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
			Server.socketList.remove(socket);//��������쳣��˵���ÿͻ��˳������⣬�򽫸ÿͻ����Ƴ�����
		}
		return null;
	}
}
