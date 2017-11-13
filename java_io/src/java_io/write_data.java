package java_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class write_data {
	public void write(String filepath,String data){
		try{
			File file = new File(filepath);
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(data);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
