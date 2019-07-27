package com.imooc.inetadderss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReciverThread implements Runnable {
    private Socket s;
    BufferedReader br = null;
    //多条接收
    public ClientReciverThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public void run(){
        try {
            String s = null;
            while (true) {
                while ((s = br.readLine()) != null) {
                    System.out.println(s);
                }
            }
            }catch(Exception e){
                e.printStackTrace();
            }

    }
}