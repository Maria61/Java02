package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/11 21:02
 */

//什么鬼东西
public class HttpServer {
    private static final int PORT = 9999;
    private static final int COUNT
            = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService EXE
            = Executors.newFixedThreadPool(COUNT);

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket socket = server.accept();
                EXE.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream is = socket.getInputStream();
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                            String requestLine = br.readLine();

                            Request requst = new Request();
                            String[] requestLines = requestLine.split(" ");
                            requst.setMethod(requestLines[0]);
                            requst.setUrl(requestLines[1]);
                            requst.setVersion(requestLines[2]);

                            String requestHeader;
                            while ((requestHeader = br.readLine()).length() != 0) {
                                String[] headers = requestHeader.split(":");
                                requst.addHeaders(headers[0], headers[1].trim());//????
                            }
                            System.out.println(requst);
                            String requestParameter;
                            char[] chars = new char[1024];
                            br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
