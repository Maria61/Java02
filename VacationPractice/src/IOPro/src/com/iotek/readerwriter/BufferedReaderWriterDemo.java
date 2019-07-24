package com.iotek.readerwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �����ı��ļ�
 * @author Marie
 *
 */
public class BufferedReaderWriterDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("F:\\2019-06-01-����\\ArrayList.java");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("f:\\zhangsan\\my2.java");
		BufferedWriter bw = new BufferedWriter(fw);
		String line = null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
			bw.write(line);
			bw.newLine();//����
			
		}
		br.close();
		bw.close();
		
	}

}
