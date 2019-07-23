package com.fehead;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("F:\\MATLAB\\R2017b\\bin");
//		System.out.println(file.canRead());//�ж��Ƿ�ɶ�
//		System.out.println(file.getAbsolutePath());//���ظ�·���ľ���·���ַ���
//		System.out.println(file.getParent());//���ظ�·������һ����·�������ַ���
//		System.out.println(file.getParentFile());//���ظ�·������һ��
//		System.out.println(file.isFile());
//		System.out.println(file.isDirectory());
//		System.out.println(file.exists());//����
		System.out.println(file.length());// ��file ��·��Ϊһ��Ŀ¼ʱ������ֵδָ����Ϊ0
//		
		File file1 = new File("f:\\Java�μ�\\17-Java������.pdf");
		System.out.println(file1.exists());
		System.out.println(file1.length());
//		System.out.println(file.delete());//ֻ��ɾ����Ŀ¼������
//		
		File myFile = new File("f:\\zhangsan");
		System.out.println("����Ŀ¼"+myFile.getName()+":"+myFile.mkdir());//����Ŀ¼
//		System.out.println(myFile.delete());
		
		File myFile1 = new File("f:\\zhangsan\\lisi");
		System.out.println("����Ŀ¼"+myFile1.getName()+":"+myFile1.mkdir());//����Ŀ¼
		File myFile20 = new File("f:\\zhangsan\\lisi\\my0.txt");
		System.out.println("�����ļ�"+myFile20.getName()+":"+myFile20.createNewFile());//�����ļ�
		File myFile21 = new File("f:\\zhangsan\\lisi\\my1.txt");
		System.out.println("�����ļ�"+myFile21.getName()+":"+myFile21.createNewFile());
		File myFile22 = new File("f:\\zhangsan\\lisi\\my2.gif");
		System.out.println("�����ļ�"+myFile22.getName()+":"+myFile22.createNewFile());
		File myFile23 = new File("f:\\zhangsan\\lisi\\my3.gif");
		System.out.println("�����ļ�"+myFile23.getName()+":"+myFile23.createNewFile());
		File myFile2 = new File("f:\\zhangsan\\wangwu");
		System.out.println("����Ŀ¼"+myFile2.getName()+":"+myFile2.mkdir());
//		String[] files = file.list();
//		for(String f:files) {
//			System.out.println(f);
//		}
		/**
		 * ���ˣ��õ���Ӧ���ļ�
		 */
//		String[] files1 = myFile.list(new FilenameFilter() {
//			@Override
//			public boolean accept(File dir,String name) {
//				return name.endsWith(".gif");
//			}
//		});
//		for(String f:files1) {
//			System.out.println(f);
//		}
		
//		File[] files2 = myFile.listFiles();//���ظ�Ŀ¼�е��ļ�
//		for(File f:files2) {
//			System.out.println(f.getName()+"--"+f.length());
//		}
		
//		File[] files3 = myFile.listFiles(new FilenameFilter() {//���ؾ� ���� ����ļ�
//
//			@Override
//			public boolean accept(File dir, String name) {
//				// TODO Auto-generated method stub
//				return name.endsWith(".gif");
//			}
//		});
//		for(File f:files3) {
//			System.out.println(f.getName()+"--"+f.length());
//		}
		
		File[] files4 = myFile.listFiles(new FileFilter() {//���� ������ ����ļ�

			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.getName().endsWith(".txt");
			}
			
		});
		for(File f:files4) {
			System.out.println(f.getName()+"--"+f.length());
		}
		
	}

}
