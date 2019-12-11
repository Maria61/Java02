package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/8 17:08
 */
//服务端
public class TcpServer {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        InputStreamReader ins = null;
        BufferedReader reader = null;
        try {
            ServerSocket server = new ServerSocket(PORT);
            Socket socket = server.accept();//不同的客户端，对应不同的socket对象
            //服务端接收客服端数据输入流
            inputStream = socket.getInputStream();
            ins = new InputStreamReader(inputStream);
            reader = new BufferedReader(ins);
            //服务端发送数据输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(os, true);
            String data = null;
            Scanner sc = new Scanner(System.in);
            while ((data = reader.readLine()) != null) {
                System.out.println("服务端接收到：" + data);
                System.out.print("服务端：");
                String s = sc.nextLine();
                writer.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            ins.close();
            inputStream.close();

        }

    }
}
