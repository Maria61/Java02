package com.iotek.otherio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
	���̸߳����ļ�
*/
public class MutiCopyFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MutiCopyFileUtil copyFileUtil = new MutiCopyFileUtil("F:\\��ʮ���� IO��\\130-IO���-1.mp4",
				"f:\\zhangsan\\threadCopyFile.mp4",4);
		copyFileUtil.copyFile();
	}

}

class MutiCopyFileUtil {
	private String src;//Դ�ļ�
	private String dst;//Ŀ���ļ�
	private int threadSize;//���������߳�ȥ����Դ�ļ�
	
	public MutiCopyFileUtil(String src, String dst, int threadSize) {
		super();
		this.src = src;
		this.dst = dst;
		this.threadSize = threadSize;
	}
	//�����ļ�����
	public void copyFile() {
		File file = new File(src);
		long fSize =  file.length();
		long block = fSize%threadSize == 0 ? fSize/threadSize:fSize/threadSize+1;
		
		//�����߳�
		for(int threadId = 0;threadId<threadSize;threadId++) {
			new DownLoadThread(fSize,block,threadId).start();
		}
	}
	
	/**
	 * �����߳�
	 */
	private class DownLoadThread extends Thread{
		private long fSize;//�ļ���С
		private long block;//ÿ���߳�Ҫ���ص��ֽ�����С
		private int threadId;//�̵߳�id,��0 ��ʼ
		private int bufSize=1024*1024;//��������С
		
		public DownLoadThread(long fSize, long block, int threadId) {
			super();
			this.fSize = fSize;
			this.block = block;
			this.threadId = threadId;
		}
		@Override 
		public void run() {
			try {
				RandomAccessFile reader = new RandomAccessFile(src,"r");
				RandomAccessFile writer = new RandomAccessFile(dst,"rw");
				long startPosition = threadId*block;//�߳����صĿ�ʼλ��
				//�߳̽������ص�λ��
				long endPosition = startPosition+block>fSize?fSize:startPosition+block;
				reader.seek(startPosition);
				writer.seek(startPosition);
				byte [] buff = new byte[bufSize];//���û�������С
				//��ʼѭ�� ���ض�д
				while(startPosition<endPosition) {
					int len = 0;
					if(startPosition+bufSize<endPosition) {//��δ����
						len = reader.read(buff);//����������
					}else {
						len = reader.read(buff,0,(int)(endPosition-startPosition));//�����������������ֽڶ���������
					}
					startPosition += len;
					writer.write(buff,0,len);
					System.out.println("�߳�"+(threadId+1)+"���أ�"+len+"�ֽ�");
				}
				reader.close();
				writer.close();
				System.out.println("�߳�"+(threadId+1)+"�������");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}