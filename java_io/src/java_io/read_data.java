package java_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class read_data {
	public String read(String filepath){
		String s="";
		String sb="";
		try{
			File file = new File(filepath);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			while((sb=br.readLine())!=null){
				s=s+sb;
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
}
