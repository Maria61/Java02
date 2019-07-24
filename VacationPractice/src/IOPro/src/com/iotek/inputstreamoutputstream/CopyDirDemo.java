package com.iotek.inputstreamoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * �����ļ���
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
 * 1.����Ŀ���ļ���
 * 2.�����ļ����е�����
 * 3.�ж����ļ��͸���
 * 4.�ж����ļ��о͵ݹ�
 */
class CopyDirUtil{
	public static void CopyDir(File src,File dst) throws IOException {
		dst.mkdirs();//�����ļ���
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
