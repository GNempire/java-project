package fcfs;

import java.io.IOException;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int answer=0;
		int reset=0;
		List<task> list = new ArrayList<task>();
		String FilePath="./demo/input.txt";
		System.out.println("请输入进程调度类型:\n"
						+  "1.先来先服务单队列\n"
						+  "2.先来先服务双队列\n");
		System.out.print("请选择:");
		Scanner scanner = new Scanner(System.in);
		answer=scanner.nextInt();
		read_data rd = new read_data();
		list=rd.read(FilePath);
		if (answer==1){
			fcfs_single f=new fcfs_single();
			f.fcfs(list);
			f.printList(list);
		}
		if (answer==2){
			fcfs_double f=new fcfs_double();
			f.fcfs(list);
			f.printList(list);
		}
		
	}
}
