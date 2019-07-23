package com.fehead;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("F:\\MATLAB\\R2017b\\bin");
//		System.out.println(file.canRead());//判断是否可读
//		System.out.println(file.getAbsolutePath());//返回该路径的绝对路径字符串
//		System.out.println(file.getParent());//返回该路径的上一级的路径名称字符串
//		System.out.println(file.getParentFile());//返回该路径的上一级
//		System.out.println(file.isFile());
//		System.out.println(file.isDirectory());
//		System.out.println(file.exists());//存在
		System.out.println(file.length());// 当file 的路径为一个目录时，返回值未指定，为0
//		
		File file1 = new File("f:\\Java课件\\17-Java聊天室.pdf");
		System.out.println(file1.exists());
		System.out.println(file1.length());
//		System.out.println(file.delete());//只能删除空目录！！！
//		
		File myFile = new File("f:\\zhangsan");
		System.out.println("创建目录"+myFile.getName()+":"+myFile.mkdir());//创建目录
//		System.out.println(myFile.delete());
		
		File myFile1 = new File("f:\\zhangsan\\lisi");
		System.out.println("创建目录"+myFile1.getName()+":"+myFile1.mkdir());//创建目录
		File myFile20 = new File("f:\\zhangsan\\lisi\\my0.txt");
		System.out.println("创建文件"+myFile20.getName()+":"+myFile20.createNewFile());//创建文件
		File myFile21 = new File("f:\\zhangsan\\lisi\\my1.txt");
		System.out.println("创建文件"+myFile21.getName()+":"+myFile21.createNewFile());
		File myFile22 = new File("f:\\zhangsan\\lisi\\my2.gif");
		System.out.println("创建文件"+myFile22.getName()+":"+myFile22.createNewFile());
		File myFile23 = new File("f:\\zhangsan\\lisi\\my3.gif");
		System.out.println("创建文件"+myFile23.getName()+":"+myFile23.createNewFile());
		File myFile2 = new File("f:\\zhangsan\\wangwu");
		System.out.println("创建目录"+myFile2.getName()+":"+myFile2.mkdir());
//		String[] files = file.list();
//		for(String f:files) {
//			System.out.println(f);
//		}
		/**
		 * 过滤，得到相应的文件
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
		
//		File[] files2 = myFile.listFiles();//返回该目录中的文件
//		for(File f:files2) {
//			System.out.println(f.getName()+"--"+f.length());
//		}
		
//		File[] files3 = myFile.listFiles(new FilenameFilter() {//返回经 过滤 后的文件
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
		
		File[] files4 = myFile.listFiles(new FileFilter() {//返回 经过滤 后的文件

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
