package com.iotek.otherio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
	多线程复制文件
*/
public class MutiCopyFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MutiCopyFileUtil copyFileUtil = new MutiCopyFileUtil("F:\\第十六章 IO流\\130-IO框架-1.mp4",
				"f:\\zhangsan\\threadCopyFile.mp4",4);
		copyFileUtil.copyFile();
	}

}

class MutiCopyFileUtil {
	private String src;//源文件
	private String dst;//目标文件
	private int threadSize;//开启多少线程去复制源文件
	
	public MutiCopyFileUtil(String src, String dst, int threadSize) {
		super();
		this.src = src;
		this.dst = dst;
		this.threadSize = threadSize;
	}
	//拷贝文件方法
	public void copyFile() {
		File file = new File(src);
		long fSize =  file.length();
		long block = fSize%threadSize == 0 ? fSize/threadSize:fSize/threadSize+1;
		
		//开启线程
		for(int threadId = 0;threadId<threadSize;threadId++) {
			new DownLoadThread(fSize,block,threadId).start();
		}
	}
	
	/**
	 * 创建线程
	 */
	private class DownLoadThread extends Thread{
		private long fSize;//文件大小
		private long block;//每个线程要下载的字节数大小
		private int threadId;//线程的id,从0 开始
		private int bufSize=1024*1024;//缓冲区大小
		
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
				long startPosition = threadId*block;//线程下载的开始位置
				//线程结束下载的位置
				long endPosition = startPosition+block>fSize?fSize:startPosition+block;
				reader.seek(startPosition);
				writer.seek(startPosition);
				byte [] buff = new byte[bufSize];//设置缓冲区大小
				//开始循环 下载读写
				while(startPosition<endPosition) {
					int len = 0;
					if(startPosition+bufSize<endPosition) {//还未读完
						len = reader.read(buff);//读满缓冲区
					}else {
						len = reader.read(buff,0,(int)(endPosition-startPosition));//将读不满缓冲区的字节读进缓冲区
					}
					startPosition += len;
					writer.write(buff,0,len);
					System.out.println("线程"+(threadId+1)+"下载："+len+"字节");
				}
				reader.close();
				writer.close();
				System.out.println("线程"+(threadId+1)+"下载完成");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}