package sjf;

import java.io.*;
import java.util.*;

public class write_data {
	private int data[]={6,2,1,3,9};
	public void write(String filePath){
		Random random = new Random();
		int number=0;
		int no=1;
		try{
			File file = new File(filePath);
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			for(int i=0;i<100;i++,no++){
				number=random.nextInt(5);
				out.write(no + " " + i + " " + data[number] +"\r\n");
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
