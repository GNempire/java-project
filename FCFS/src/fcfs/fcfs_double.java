package fcfs;

import java.util.*;

public class fcfs_double {
	public List<task> fcfs(List<task> list){
		int weightTurnAroundTime[]={0,0};		//����������������ʾ���±�Ϊ0��ʾ����1���±�Ϊ1��ʾ����2
		int turnAroundTime[]={0,0};
		int finishingTime[]={0,0};
		int startingTime[]={0,0};
		int serviceTime[]={0,0};
		int arrivalTime[]={0,0};
		int taskID[]={0,0};
		task t1 = new task();				//����1��Ӧ���������
		task t2 = new task();				//����2��Ӧ���������
		int i=0;							//����������±�
		int s1=-1;							//����1�����2����ִ������ķ���ʱ�䣬����Ϊ-1�Ƿ�ֹ��ִ�е�һ������ʱ����2��ɵĳ�ͻ
		int s2=-1;
		Queue<task> queue=new LinkedList<task>();	//��ʼ������
		System.out.println("Ĭ�϶���һ��ִ������");
		System.out.println("ʱ��\t��������\t����1��ʼ����\t����1�������\t����2��ʼ����\t����2�������");
		for(int time=0;;time++){
			//����1
			if (i<list.size()){			//������δ������ϣ����µ��������������
				queue.offer(list.get(i));
			}
			if (queue.peek()==null){	//�����ж϶����е������Ƿ���ȫִ����
				if (s1<0){
					if (s2<0){			//������1�����2������ִ������ķ���ʱ�䶼С��0���������������������ִ����ϣ�ֹͣ����ִ�г���
						break;
					}
				}
				if (s2<0){
					if (s1<0){
						break;
					}
				}
			}
			if (taskID[0]==0){				
				if (queue.peek()!=null){		//�����в�Ϊ��
					t1=new task();
					t1=(task)queue.poll();		//ȡ����ɾ�������е�һ������
					taskID[0]=t1.getTaskID();
					arrivalTime[0]=t1.getArrivalTime();
					serviceTime[0]=t1.getServiceTime();
					startingTime[0]=time;
					s1=serviceTime[0];
					if (i<list.size()){
						System.out.print(time+"\t"+list.get(i).getTaskID()+"\t"+taskID[0]+"\t\t\t\t");
					}
					else{
						System.out.print(time+"\t"+"\t"+taskID[0]+"\t\t\t\t");
					}
				}
				else{
					System.out.print(time+"\t\t\t\t\t\t");
				}
			}
			else if (s1==0){			
				if (i<list.size()){
					System.out.print(time+"\t"+list.get(i).getTaskID()+"\t\t\t"+taskID[0]+"\t\t");
				}
				else{
					System.out.print(time+"\t"+"\t\t\t"+taskID[0]+"\t\t");
				}
				finishingTime[0]=time;
				turnAroundTime[0]=finishingTime[0]-arrivalTime[0];
				weightTurnAroundTime[0]=turnAroundTime[0]/serviceTime[0];
				t1.setStartingTime(startingTime[0]);
				t1.setFinishingTime(finishingTime[0]);
				t1.setTurnAroundTime(turnAroundTime[0]);
				t1.setWeightTurnAroundTime(weightTurnAroundTime[0]);
				list.set(taskID[0]-1,t1);
				taskID[0]=0;
			}
			else{
				if (i<list.size()){
					System.out.print(time+"\t"+list.get(i).getTaskID()+"\t\t\t\t\t");
				}
				else{
					System.out.print(time+"\t\t\t\t\t\t");
				}
			}
			
			
			
			
			//����2��������������1��ͬ
			if (taskID[1]==0){
				if (queue.peek()!=null){
					t2=new task();
					t2=queue.poll();
					taskID[1]=t2.getTaskID();
					arrivalTime[1]=t2.getArrivalTime();
					serviceTime[1]=t2.getServiceTime();
					startingTime[1]=time;
					s2=serviceTime[1];
					if (i<list.size()){
						System.out.print(taskID[1]);
					}
					else{
						System.out.print(taskID[1]);
					}
				}
			}
			else if (s2==0){
				if (i<list.size()){
					System.out.print("\t\t"+taskID[1]);
				}
				else{
					System.out.print("\t\t"+taskID[1]);
				}
				finishingTime[1]=time;
				turnAroundTime[1]=finishingTime[1]-arrivalTime[1];
				weightTurnAroundTime[1]=turnAroundTime[1]/serviceTime[1];
				t2.setStartingTime(startingTime[1]);
				t2.setFinishingTime(finishingTime[1]);
				t2.setTurnAroundTime(turnAroundTime[1]);
				t2.setWeightTurnAroundTime(weightTurnAroundTime[1]);
				list.set(taskID[1]-1,t2);
				taskID[1]=0;
			}
			if (i<list.size()){
				i++;
			}
			System.out.println();
			s1--;
			s2--;
		}
		return list;
	}
	public void printList(List<task> list){
		task t=new task();
		System.out.println("������\t����ʱ��\t����ʱ��\t��ʼʱ��\t���ʱ��\t��תʱ��\t��Ȩ��תʱ��");
		for(int i=0;i<list.size();i++){
			t=list.get(i);
			System.out.println(t.getTaskID()+"\t"+t.getArrivalTime()+"\t"+t.getServiceTime()+"\t"+
			t.getStartingTime()+"\t"+t.getFinishingTime()+"\t"+t.getTurnAroundTime()+"\t"+t.getWeightTurnAroundTime());
		}
	}
}
