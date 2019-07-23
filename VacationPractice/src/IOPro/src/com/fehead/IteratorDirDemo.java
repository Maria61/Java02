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
	private static int level = 0;//层级数
	
	public static void iteratorDir(File file) {
		if(file!=null) {
			//如果是文件或者空目录就返回(即里面没有要打印的文件后者文件夹)
			if(file.isFile()||file.listFiles().length==0) {
				return;//递归出口
			}else {
				File[] files = file.listFiles();//遍历目录
				files = sort(files);//给目录排序，先目录后文件
				for(File f:files) {//循环打印
					StringBuffer sb = new StringBuffer();
					if(f.isFile()) {
						sb.append(getTab(level));//根据层级数在名字前面添加空格
						sb.append(f.getName());
					}else {
						sb.append(getTab(level));
						sb.append(f.getName());
						sb.append("\\");
					}
					System.out.println(sb.toString());
					//如果是文件夹，进入并遍历
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
	 * 对File类型的数组进行先目录后文件的排列
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
	 * 根据层级数添加空格
	 */
	public static String getTab(int level) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<level;i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
