package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/11 21:02
 */
//���-->�����߼�-->��Ӧ����װ��http
public class HttpServer {
    private static final int PORT = 9999;
    //��ȡ��������������������������߳�������CPU���ڴ����Դ�����
    private static final int COUNT
            = Runtime.getRuntime().availableProcessors();
    //ʹ���̳߳أ�Ч�ʸ��ߣ����븴����ǿ
    private static final ExecutorService EXE
            = Executors.newFixedThreadPool(COUNT);//�����̶���СΪCOUNT���̳߳�




    public static final Map<String, Object> SESSION_MAP = new HashMap<>();
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                //��ȡ�ͻ�������socket����
                Socket socket = server.accept();//����ʽ����
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
                //��������������
                is = socket.getInputStream();
                //ת�������ֽ���ת��Ϊ�ַ�����
                br = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                Request request = new Request();
                //�������ݵĽ�����httpЭ�鱨�Ľ��
                //1.���������У���һ�У���method url version
                String requestLine = br.readLine();//��ȡ������//readLine()����ʽ����,����main���߳�
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
                //2.��������ͷ��
                //key:value ÿ�����ỻ�У�
                String header;
                while ((header = br.readLine()) != null && header.length() != 0) {
                    String key = header.substring(0, header.indexOf(":"));
                    String value = header.substring(header.indexOf(":") + 1);
                    request.addHeader(key, value.trim());//trim()ȥ���ַ���ǰ��ո�
                }
                //POST������Ҫ��������ͷContent-Length ��ȡ������ĳ���
                if ("POST".equals(request.getMethod())) {
                    String len = request.getHeader("Content-Length");
                    if (len != null) {
                        int l = Integer.parseInt(len);
                        char[] chars = new char[l];
                        //��ȡ������
                        br.read(chars, 0, l);
                        //���������ʽ
                        String requestBody = new String(chars);
                        request.parseParameters(requestBody);
                    }
                }
                System.out.println(request);

                //�������Ӧ����
                os = socket.getOutputStream();
                pw = new PrintWriter(os, true);//��Ҫ�Զ�ˢ��

                if ("/302".equals(request.getUrl())) {
                    pw.println("HTTP/1.0 302 �ض���");
                    pw.println("Content-Type: text/html;charset=utf-8");
                    pw.println("Location: https://www.baidu.com");
                } else if ("/login".equals(request.getUrl())) {
                    pw.println("HTTP/1.1 200 OK");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    //�ж��û��������Ƿ�Ϸ�
                    String sessionId = UUID.randomUUID().toString();
                    HttpServer.SESSION_MAP.put(sessionId, username);
                    pw.println("Set-Cookie: SESSIONID=" + sessionId);
                    pw.println("Content-Type: text/html;charset=utf-8");
                    String content = "<h2>��ӭ�û�["
                            + request.getParameter("username")
                            + "]��¼</h2>";
                    pw.println("Content-Length: " + content.getBytes().length);
                    pw.println();
                    pw.println(content);
                } else if ("/setCookie".equals(request.getUrl())) {//����cookie,��¼��¼�ÿ�
                    pw.println("HTTP/1.1 200 OK");
                    String sessionId = UUID.randomUUID().toString();//��������ַ���
                    pw.println("Set-Cookie: SESSIONID=" + sessionId);
                    pw.println("Content-Type: text/html;charset=utf-8");
                    String content = "����Cookie�ɹ�";
                    pw.println("Content-Length: " + content.getBytes().length);
                    pw.println();

                    pw.println(content);
                } else if ("/getCookie".equals(request.getUrl())) {//????
                    String cookie = request.getHeader("Cookie");
                    String[] cookies = cookie.split(";");
                    for (String s : cookies) {
                        String[] s2 = s.split("=");
                        String key = s2[0].trim();
                        String value = s2[1].trim();
                        if (key.equals("SESSIONID")
                                && HttpServer.SESSION_MAP.containsKey(value)) {
                            pw.println("HTTP/1.1 200 OK");
                            pw.println("Content-Type: text/html; charset=utf-8");
                            String content = "<h2>�û�"
                                    + HttpServer.SESSION_MAP.get(value) + "�ܹ�����</h2>";
                            pw.println("Content-Length: " + content.getBytes().length);
                            pw.println();
                            pw.println(content);
                            return;
                        }
                    }
                    pw.println("HTTP/1.1 403 Forbidden");
                    pw.println("Content-Type: text/html; charset=utf-8");
                    String content = "û�з���Ȩ��";
                    pw.println("Content-Length: " + content.getBytes().length);
                    pw.println();
                    pw.println(content);
                } else {
                    //����/login.html,ת��Ϊ����./login.html
                    InputStream htmlIs = HttpServer.class.getClassLoader()
                            .getResourceAsStream("." + request.getUrl());//����ֵ��
                    if (htmlIs != null) {
                        pw.println("HTTP/1.1 200 OK");
                        pw.println("Content-Type: text/html;charset=utf-8");
                        pw.println();
                        //���ؾ�̬��Դ�ļ�
                        InputStreamReader htmlIsr = new InputStreamReader(htmlIs);//�ֽ���ת��Ϊ�ַ���
                        BufferedReader bf = new BufferedReader(htmlIsr);
                        String content;
                        while ((content = bf.readLine()) != null) {
                            pw.println(content);
                        }

                    } else {
                        //����404
                        pw.println("HTTP/1.1 404 Not Found");
                        pw.println("Content-Type: text/html;charset=utf-8");
                        pw.println();
                        pw.println("<h2>�Ҳ�����Դ</h2>");
                    }
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
