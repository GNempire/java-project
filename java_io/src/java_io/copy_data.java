package java_io;

import java.io.*;

public class copy_data {
	public void copy(String filepath,String FILEPATH) throws IOException{
		File file1=new File(filepath);
		File file2=new File(FILEPATH);
		if (file1.isFile() && file2.isFile()){
			FileInputStream fis=new FileInputStream(file1);
			FileOutputStream fos=new FileOutputStream(file2);
			byte [] buffer=new byte[1024];
			int len=0;
			while((len=fis.read(buffer))!=-1){
				fos.write(buffer,0,len);
			}
		}
	}
}
