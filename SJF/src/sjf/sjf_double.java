package sjf;

import java.util.*;

public class sjf_double {
	public List<task> fcfs(List<task> list){
		List<task> l=new ArrayList<task>();
		int result=0;
		int weightTurnAroundTime[]={0,0};		//将任务各属性数组表示，下标为0表示队列1，下标为1表示队列2
		int turnAroundTime[]={0,0};
		int finishingTime[]={0,0};
		int startingTime[]={0,0};
		int serviceTime[]={0,0};
		int arrivalTime[]={0,0};
		int taskID[]={0,0};
		task t1 = new task();				//队列1对应的任务对象
		task t2 = new task();				//队列2对应的任务对象
		int i=0;							//到达任务的下标
		int s1=-1;							//队列1与队列2正在执行任务的服务时间，设置为-1是防止在执行第一个任务时队列2造成的冲突
		int s2=-1;
		int number=0;
		System.out.println("默认队列一先执行任务");
		System.out.println("时间\t到达任务\t队列1开始任务\t队列1完成任务\t队列2开始任务\t队列2完成任务");
		for(int time=0;;time++){
			//队列1
			if (i<list.size()){
				l.add(list.get(i));
			}
			if (number>=list.size()){	//用于判断队列中的任务是否被完全执行完
				if (s1<0){
					if (s2<0){			//若队列1与队列2的正在执行任务的服务时间都小于0，则表明队列中所有任务执行完毕，停止继续执行程序
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
				if (l.size()>=1){		//若队列不为空
					t1=new task();
					result=judge(l);
					
					delete(l,result);
					t1=list.get(result-1); 		//取出并删除队列中第一个任务
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
				number++;
			}
			else{
				if (i<list.size()){
					System.out.print(time+"\t"+list.get(i).getTaskID()+"\t\t\t\t\t");
				}
				else{
					System.out.print(time+"\t\t\t\t\t\t");
				}
			}
			
			
			
			
			//队列2，具体操作与队列1相同
			if (taskID[1]==0){
				if (l.size()>=1){
					t2=new task();
					result=judge(l);
					
					delete(l,result);
					t2=list.get(result-1); 
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
				number++;
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
		return result[n];			//返回任务编号
	}
	public void printList(List<task> list){
		task t=new task();
		System.out.println("任务编号\t到达时间\t服务时间\t开始时间\t完成时间\t周转时间\t带权周转时间");
		for(int i=0;i<list.size();i++){
			t=list.get(i);
			System.out.println(t.getTaskID()+"\t"+t.getArrivalTime()+"\t"+t.getServiceTime()+"\t"+
			t.getStartingTime()+"\t"+t.getFinishingTime()+"\t"+t.getTurnAroundTime()+"\t"+t.getWeightTurnAroundTime());
		}
	}
}
