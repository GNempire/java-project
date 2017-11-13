package file_tree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class write_data {
	public void write(String filepath,List<file> list){
		file f;
		try{
			File file = new File(filepath);
			FileWriter out=new FileWriter(filepath, true);
			for (int i=0;i<list.size();i++){
				f=list.get(i);
				out.write(f.getFilename()+" "+f.getSize()+" "+f.getLastmodifytime()+"\n");
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
