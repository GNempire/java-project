package sjf;

import java.io.*;
import java.util.*;


public class read_data {
	public List<task> read(String filePath){
		List<task> list = new ArrayList<task>();
		String line=" ";
		String [] array;
		int i=0;
		int taskID;
		int arrivalTime;
		int serviceTime;
		try{
			File file = new File(filePath);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			while(line!=null){
				line=br.readLine();
				if (line!=null){
					array=line.split("\\s{1,}");
					taskID=Integer.parseInt(array[0]);
					arrivalTime=Integer.parseInt(array[1]);
					serviceTime=Integer.parseInt(array[2]);
					task t = new task();
					t.setTaskID(taskID);
					t.setArrivalTime(arrivalTime);
					t.setServiceTime(serviceTime);
					list.add(i,t);
					i++;
				}
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
