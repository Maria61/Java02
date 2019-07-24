package com.iotek.readerwriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 复制一个文本文件
 * @author Marie
 *
 */

public class FileReaderWriterDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("f:\\zhangsan\\my3.txt");
		FileWriter fw = new FileWriter("f:\\zhangsan\\lisi\\my3(2).txt");//自带8k的缓冲区，当缓冲区未满时，
																		//可调用flush,强制清空缓冲区
		int len = 0;
		char[] buf = new char[100];//缓冲区
		while((len=fr.read(buf))!=-1) {
			fw.write(buf, 0, len);
		}
		fr.close();
		fw.close();//会自动调用flush清空缓冲区
	}

}
