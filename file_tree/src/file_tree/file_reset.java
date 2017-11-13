package file_tree;

import java.io.*;

public class file_reset {
	public void reset(String filename){
        try {
        	File file =new File(filename);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
