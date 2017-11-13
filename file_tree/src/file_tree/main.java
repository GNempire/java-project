package file_tree;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=0;
		String filepath="";
		String FILEPATH="./demo/demo.txt";
		file_reset fr=new file_reset();
		fr.reset(FILEPATH);
		System.out.print("请输入文件夹地址:");
		Scanner scanner = new Scanner(System.in);
		filepath=scanner.nextLine();
		read_file rf=new read_file();
		result=rf.read(filepath);
		if (result < 0){
			return;
		}
		read_data rd=new read_data();
		rd.read(FILEPATH);
	}

}
