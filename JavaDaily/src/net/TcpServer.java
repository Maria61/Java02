package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
            inputStream = socket.getInputStream();
            ins = new InputStreamReader(inputStream);
            reader = new BufferedReader(ins);
            String data = null;
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
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
