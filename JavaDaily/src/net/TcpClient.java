package net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/8 17:18
 */
//客户端
public class TcpClient {
    private static final String HOST = "localhost";
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            Socket socket = new Socket(HOST, PORT);
            //客户端发送数据输出流
            os = socket.getOutputStream();
            pw = new PrintWriter(os, true);
            //客户端接收数据输出流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            Scanner sc = new Scanner(System.in);
            System.out.print("客服端：");
            while (sc.hasNext()) {
                String s = sc.nextLine();
                pw.println(s);
                String content = br.readLine();
                System.out.println("客户端接收到：" + content);
                System.out.print("客服端：");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
            os.close();
        }


    }
}
