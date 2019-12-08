package net;

import java.io.*;
import java.net.Socket;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/8 17:18
 */
public class TcpClient {
    private static final String HOST = "localhost";
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println("hhhhhhhhh");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }
}
