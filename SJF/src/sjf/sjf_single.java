package sjf;

import java.util.*;

public class sjf_single {
	public List<task> sjf(List<task> list){
		List<task> l=new ArrayList<task>();
		int result=0;
		int weightTurnAroundTime=0;  //��Ȩ��תʱ��
		int turnAroundTime=0;        //��תʱ��
		int finishingTime=0;		 //���ʱ��
		int startingTime=0;			 //��ʼʱ��
		int serviceTime=0;			 //����ʱ��
		int arrivalTime=0;			 //����ʱ��
		int taskID=0;				 //������
		task t = new task();		 //���ڵõ�List�е�������Ķ���
		int i=0;					 //ÿһʱ�̵���������List�еı�ţ���List.add(i��task)�е�i
		int s=0;					 //�������÷���ʱ��
		int number=0;
		l.add(list.get(i));
		System.out.println("ʱ��\t��������\t��ʼ����\t�������");
		for(int time=0;number<list.size();time++){
			if (taskID==0){          //��taskID=0,��List�еõ��µ����񣬲���ȡ���������
				t=new task();  
				result=judge(l);
				delete(l,result);
				t=list.get(result-1);       
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
				number++;
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
			if (i<list.size()){
				l.add(list.get(i));
			}
			s--;		//��ǰ�������ʱ�����1
		}
		return list;
	}
	public void delete(List<task> list,int taskID){
		for (int i=0;i<list.size();i++){
			 if (list.get(i).getTaskID()==taskID){
				 list.remove(i);
			 }
		}
	}
	public int judge(List<task> list){
		int	[] result=new int[100];
		int shortest=100000;
		int number=0;
		int n=0;
		int first=100000;
		for(int i=0;i<list.size();i++){
			if (list.get(i).getServiceTime()<shortest){
				shortest=list.get(i).getServiceTime();
			}
		}
		for (int j=0;j<list.size();j++){
			if (list.get(j).getServiceTime()==shortest){
				result[number]=list.get(j).getTaskID();
				if (first>list.get(j).getArrivalTime()){
					first=list.get(j).getArrivalTime();
					n=number;
				}
				number++;
			}
		}
		return result[n];			//����������
	}
	public void printList(List<task> list){		//��ӡ��������������
		task t=new task();
		System.out.println("������\t����ʱ��\t����ʱ��\t��ʼʱ��\t���ʱ��\t��תʱ��\t��Ȩ��תʱ��");
		for(int i=0;i<list.size();i++){
			t=list.get(i);
			System.out.println(t.getTaskID()+"\t"+t.getArrivalTime()+"\t"+t.getServiceTime()+"\t"+
			t.getStartingTime()+"\t"+t.getFinishingTime()+"\t"+t.getTurnAroundTime()+"\t"+t.getWeightTurnAroundTime());
		}
	}
}
