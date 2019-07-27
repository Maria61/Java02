package com.imooc.inetadderss;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main  (String[] args) throws Exception {
        Socket s= new Socket("192.168.0.113", 2345);
        new Thread(new ClientReciverThread(s)).start();
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line  =  null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine())!=null){
            ps.println(line);
        }
        //s.shutdownOutput();//πÿ±’ ‰»Î¡˜
    }
}