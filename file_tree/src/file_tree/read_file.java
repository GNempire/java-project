package file_tree;

import java.io.*;
import java.util.*;

public class read_file {
	public int read(String filepath){
		String filePath="./demo/demo.txt";
		List<file> list=new ArrayList<file>();
		List<file> l=new ArrayList<file>();
		String filename="";
		long size=0;
		long lastmodifytime=0;
		int number=0;
		file f;
		File file=new File(filepath);
		if (!file.exists()){
			System.out.println("文件路径不存在");
			return -1;
		}
		File[] tempList = file.listFiles();
		System.out.println("该目录下对象个数："+tempList.length);
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isDirectory()) {
				f=new file();
				filename=tempList[i].getName();
				size=tempList[i].length();
				lastmodifytime=tempList[i].lastModified();
				f.setFilename(filename);
				f.setSize(size);
				f.setLastmodifytime(lastmodifytime);
				list.add(number,f);
				number++;
			}
		}
		number=0;
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				f=new file();
				filename=tempList[i].getName();
				size=tempList[i].length();
				lastmodifytime=tempList[i].lastModified();
				f.setFilename(filename);
				f.setSize(size);
				f.setLastmodifytime(lastmodifytime);
				l.add(number,f);
				number++;
			}
		}
		list=sort(list);
		l=sort(l);
		write_data wd=new write_data();
		wd.write(filePath, list);
		wd.write(filePath, l);
		return 1;
	}
	public List<file> sort(List<file> list){
		List<file> list_sorted=new ArrayList<file>();
		int number=list.size();
		int n=0;
		String min=list.get(0).getFilename();
		for (int i=0;i<number;i++){
			n=0;
			for (int j=0;j<list.size();j++){
				if (min.compareTo(list.get(j).getFilename())<0){
					min=list.get(j).getFilename();
					n=j;
				}
			}
			list_sorted.add(i,list.get(n));
			list.remove(n);
		}
		return list_sorted;
	}
}