package com.iotek.readerwriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * ����һ���ı��ļ�
 * @author Marie
 *
 */

public class FileReaderWriterDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("f:\\zhangsan\\my3.txt");
		FileWriter fw = new FileWriter("f:\\zhangsan\\lisi\\my3(2).txt");//�Դ�8k�Ļ���������������δ��ʱ��
																		//�ɵ���flush,ǿ����ջ�����
		int len = 0;
		char[] buf = new char[100];//������
		while((len=fr.read(buf))!=-1) {
			fw.write(buf, 0, len);
		}
		fr.close();
		fw.close();//���Զ�����flush��ջ�����
	}

}
