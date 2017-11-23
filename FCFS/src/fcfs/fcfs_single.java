package fcfs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class fcfs_single {
	public List<task> fcfs(List<task> list){
		int weightTurnAroundTime=0;  //��Ȩ��תʱ��
		int turnAroundTime=0;        //��תʱ��
		int finishingTime=0;		 //���ʱ��
		int startingTime=0;			 //��ʼʱ��
		int serviceTime=0;			 //����ʱ��
		int arrivalTime=0;			 //����ʱ��
		int taskID=0;				 //������
		task t = new task();		 //���ڵõ�List�е�������Ķ���
		int i=0;					 //ÿһʱ�̵���������List�еı�ţ���List.add(i��task)�е�i
		int j=0;					 //����ִ�е�������List�еı��
		int s=0;					 //�������÷���ʱ��
		System.out.println("ʱ��\t��������\t��ʼ����\t�������");
		for(int time=0;j<list.size();time++){
			if (taskID==0){          //��taskID=0,��List�еõ��µ����񣬲���ȡ���������
				t=new task();  
				t=list.get(j);       
				taskID=t.getTaskID();
				arrivalTime=t.getArrivalTime();
				serviceTime=t.getServiceTime();
				startingTime=time;
				s=serviceTime;
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID()+"\t"+taskID);  
				}
				else{
					System.out.println(time+"\t"+"\t"+taskID);
				}
			}
			else if (s==0){         //s=0����Ϊ����˵�ǰ����
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID()+"\t\t"+taskID);
				}
				else{
					System.out.println(time+"\t"+"\t\t"+taskID);
				}
				finishingTime=time;			//�������ʱ��
				turnAroundTime=finishingTime-arrivalTime;
				weightTurnAroundTime=turnAroundTime/serviceTime;
				t.setStartingTime(startingTime);
				t.setFinishingTime(finishingTime);
				t.setTurnAroundTime(turnAroundTime);
				t.setWeightTurnAroundTime(weightTurnAroundTime);
				list.set(taskID-1,t);
				taskID=0;		//��ɵ�ǰ����ʱ����taskID����Ϊ0���Ա���һ�ζ�ȡ����
				j++;			//j++��ʾ������ִ�е������±����һλ
			}
			else{				//��ǰ����ִ������
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID());
				}
				else{
					System.out.println(time);
				}
			}
			if (i<list.size()){			//������δȫ�����i++��ʾ���������±����һλ
				i++;
			}
			s--;		//��ǰ�������ʱ�����1
		}
		return list;
	}
	public void printList(List<task> list) throws IOException{		//��ӡ��������������
		task t=new task();
		File file = new File("./result/single_queue_result.txt");
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write("������\t����ʱ��\t����ʱ��\t��ʼʱ��\t���ʱ��\t��תʱ��\t��Ȩ��תʱ��\n");
		for(int i=0;i<list.size();i++){
			t=list.get(i);
			out.write(t.getTaskID()+"\t\t"+t.getArrivalTime()+"\t\t"+t.getServiceTime()+"\t\t"+
			t.getStartingTime()+"\t\t"+t.getFinishingTime()+"\t\t"+t.getTurnAroundTime()+"\t\t"+t.getWeightTurnAroundTime()+"\n");
		}
		out.flush();
		out.close();
	}
}
