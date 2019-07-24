package com.iotek.inputstreamoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 复制文件夹
 * @author Marie
 *
 */
public class CopyDirDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CopyDirUtil.CopyDir(new File("f:\\zhangsan\\lisi"),new File( "f:\\zhangsan\\wangwu\\lisi"));
			System.out.println("Success!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
/**
 * 1.创建目标文件夹
 * 2.遍历文件夹中的内容
 * 3.判断是文件就复制
 * 4.判断是文件夹就递归
 */
class CopyDirUtil{
	public static void CopyDir(File src,File dst) throws IOException {
		dst.mkdirs();//创建文件夹
		if(src!=null) {
			File[] files = src.listFiles();
			for(File f:files) {
				if(f.isFile()) {
					FileInputStream fis = new FileInputStream(f);
					FileOutputStream fos = new FileOutputStream(dst.getAbsoluteFile()+"\\"+f.getName());
					int len = 0;
					byte[] buf = new byte[1024*1024];
					while((len = fis.read(buf))!=-1) {
						fos.write(buf,0,len);
					}
					fis.close();
					fos.close();
				}else {
					CopyDir(f,new File(dst.getAbsoluteFile()+"\\"+f.getName()));
				}
			}
		}
		
		
	}
}
