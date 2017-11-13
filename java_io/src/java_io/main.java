package java_io;

import java.io.*;
public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String result="";
		String s="";
		System.out.print("请输入:");
		InputStream in =System.in;
		StringBuilder sb = new StringBuilder();
		while(true){
			int ch =in.read();
			if(ch=='\n'){
				s=sb.toString();
				System.out.println("控制台输出:"+s);
				break;
			}
			else{
				sb.append((char)ch);
			}
		}
		String filepath="./src.txt";
		String FILEPATH="./dest.txt";
		write_data wd=new write_data();
		wd.write(filepath, s);
		copy_data cd=new copy_data();
		cd.copy(filepath, FILEPATH);
		read_data rd=new read_data();
		result=rd.read(FILEPATH);
		System.out.println("文件内容输出"+result);
	}

}
