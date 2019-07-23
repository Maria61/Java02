package com.fehead;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IteratorDirDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IteratorUtil.iteratorDir(new File("f:\\zhangsan"));
		
	}

}
class IteratorUtil{
	private static int level = 0;//�㼶��
	
	public static void iteratorDir(File file) {
		if(file!=null) {
			//������ļ����߿�Ŀ¼�ͷ���(������û��Ҫ��ӡ���ļ������ļ���)
			if(file.isFile()||file.listFiles().length==0) {
				return;//�ݹ����
			}else {
				File[] files = file.listFiles();//����Ŀ¼
				files = sort(files);//��Ŀ¼������Ŀ¼���ļ�
				for(File f:files) {//ѭ����ӡ
					StringBuffer sb = new StringBuffer();
					if(f.isFile()) {
						sb.append(getTab(level));//���ݲ㼶��������ǰ����ӿո�
						sb.append(f.getName());
					}else {
						sb.append(getTab(level));
						sb.append(f.getName());
						sb.append("\\");
					}
					System.out.println(sb.toString());
					//������ļ��У����벢����
					if(f.isDirectory()) {
						level++;
						iteratorDir(f);
						level--;
					}
				}
			}
		}
	}
	/**
	 * ��File���͵����������Ŀ¼���ļ�������
	 */
	private static File[] sort(File[] files) {
		List<File> fileList = new ArrayList<File>();
		for(File f:files) {
			if(f.isDirectory()) {
				fileList.add(f);
			}
		}
		for(File f:files) {
			if(f.isFile()) {
				fileList.add(f);
			}
		}
		return fileList.toArray(new File[fileList.size()]);
	}
	/**
	 * ���ݲ㼶����ӿո�
	 */
	public static String getTab(int level) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<level;i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
