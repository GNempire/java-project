package sjf;

import java.io.IOException;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int answer=0;
		int reset=0;
		List<task> list = new ArrayList<task>();
		String FilePath="./demo/demo.txt";
		System.out.println("��������̵�������:\n"
						+  "1.����ҵ���ȵ�����\n"
						+  "2.����ҵ����˫����\n");
		System.out.print("��ѡ��:");
		Scanner scanner = new Scanner(System.in);
		answer=scanner.nextInt();
		read_data rd = new read_data();
		list=rd.read(FilePath);
		if (answer==1){
			sjf_single f=new sjf_single();
			f.sjf(list);
			f.printList(list);
		}
		else if (answer==2){
			sjf_double f=new sjf_double();
			f.fcfs(list);
			f.printList(list);
		}	
	}
}
