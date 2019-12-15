package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/11 21:02
 */
//解包-->处理逻辑-->响应并封装成http
public class HttpServer {
    private static final int PORT = 9999;
    //获取处理器核数：处理的任务量和线程数量、CPU、内存等资源都相关
    private static final int COUNT
            = Runtime.getRuntime().availableProcessors();
    //使用线程池：效率更高，代码复用性强
    private static final ExecutorService EXE
            = Executors.newFixedThreadPool(COUNT);//创建固定大小为COUNT的线程池

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                //获取客户端请求socket对象
                Socket socket = server.accept();//阻塞式方法

                //如果获取到请求对象，开启一个线程进行处理，否则一直阻塞不处理
//                EXE.submit(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            //输入流处理请求
//                            InputStream is = socket.getInputStream();
//                            //转换流（字节流转换为字符流）
//                            BufferedReader br = new BufferedReader(
//                                    new InputStreamReader(is,"UTF-8"));
//                            //输出流响应请求
//                            OutputStream os = socket.getOutputStream();
//                            BufferedWriter bw = new BufferedWriter(
//                                    new OutputStreamWriter(os,"UTF-8"));
//
//                            String requestLine = br.readLine();//读取请求行//readLine()阻塞式方法,阻塞main主线程
//
//                            Request requst = new Request();
//                            String[] requestLines = requestLine.split(" ");
//                            requst.setMethod(requestLines[0]);
//                            requst.setUrl(requestLines[1]);
//                            requst.setVersion(requestLines[2]);
//                            //处理请求头
//                            String requestHeader;
//                            while ((requestHeader = br.readLine()).length() != 0) {
//                                String[] headers = requestHeader.split(":");
//                                requst.addHeaders(headers[0], headers[1].trim());//字符串去除前后空格
//                            }
//                            System.out.println(requst);
//                            String requestParameter;
//                            char[] chars = new char[1024];
//                            br.readLine();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });

                EXE.submit(new HttpTask(socket));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HttpTask implements Runnable {

    private Socket socket;

    public HttpTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            try {
                //输入流处理请求
                is = socket.getInputStream();
                //转换流（字节流转换为字符流）
                br = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                Request request = new Request();
                //请求数据的解析：http协议报的解包
                //1.解析请求行（第一行）：method url version
                String requestLine = br.readLine();//读取请求行//readLine()阻塞式方法,阻塞main主线程
                String[] requestLines = requestLine.split(" ");
                request.setMethod(requestLines[0]);
                String url = requestLines[1];
                if (url.contains("?")) {
                    String parameters = url.substring(url.indexOf("?") + 1);
                    request.parseParameters(parameters);
                    url = url.substring(0, url.indexOf("?"));
                }
                request.setUrl(url);
                request.setVersion(requestLines[2]);
                //2.解析请求头：
                //key:value 每个都会换行，
                String header;
                while ((header = br.readLine()) != null && header.length() != 0) {
                    String key = header.substring(0, header.indexOf(":"));
                    String value = header.substring(header.indexOf(":") + 1);
                    request.addHeader(key, value.trim());//trim()去除字符串前后空格
                }
                //POST请求，需要根据请求头Content-Length 获取请求体的长度
                if ("POST".equals(request.getMethod())) {
                    String len = request.getHeader("Content-Length");
                    if (len != null) {
                        int l = Integer.parseInt(len);
                        char[] chars = new char[l];
                        //读取请求体
                        br.read(chars, 0, l);
                        //请求参数格式
                        String requestBody = new String(chars);
                        request.parseParameters(requestBody);
                    }
                }
                System.out.println(request);

                //输出流响应请求
                os = socket.getOutputStream();
                pw = new PrintWriter(os, true);//需要自动刷新

                //?????
                if ("/302".equals(request.getUrl())) {
                    pw.println("HTTP/1.0 302 重定向");
                    pw.println("Content-Type: text/html;charset=utf-8");
                    pw.println("Location: https://www.baidu.com");
                }


            } finally {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
