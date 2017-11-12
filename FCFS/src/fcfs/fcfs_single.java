package fcfs;

import java.util.*;

public class fcfs_single {
	public List<task> fcfs(List<task> list){
		int weightTurnAroundTime=0;  //带权周转时间
		int turnAroundTime=0;        //周转时间
		int finishingTime=0;		 //完成时间
		int startingTime=0;			 //开始时间
		int serviceTime=0;			 //服务时间
		int arrivalTime=0;			 //到达时间
		int taskID=0;				 //任务编号
		task t = new task();		 //用于得到List中到达任务的对象
		int i=0;					 //每一时刻到达任务在List中的编号，即List.add(i，task)中的i
		int j=0;					 //正在执行的任务在List中的编号
		int s=0;					 //用于设置服务时间
		System.out.println("时间\t到达任务\t开始任务\t完成任务");
		for(int time=0;j<list.size();time++){
			if (taskID==0){          //若taskID=0,从List中得到新的任务，并获取任务的数据
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
			else if (s==0){         //s=0，即为完成了当前任务
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID()+"\t\t"+taskID);
				}
				else{
					System.out.println(time+"\t"+"\t\t"+taskID);
				}
				finishingTime=time;			//计算各种时间
				turnAroundTime=finishingTime-arrivalTime;
				weightTurnAroundTime=turnAroundTime/serviceTime;
				t.setStartingTime(startingTime);
				t.setFinishingTime(finishingTime);
				t.setTurnAroundTime(turnAroundTime);
				t.setWeightTurnAroundTime(weightTurnAroundTime);
				list.set(taskID-1,t);
				taskID=0;		//完成当前任务时，将taskID设置为0，以便下一次读取任务
				j++;			//j++表示将正在执行的任务下标后移一位
			}
			else{				//当前正在执行任务
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID());
				}
				else{
					System.out.println(time);
				}
			}
			if (i<list.size()){			//若任务还未全部到达，i++表示到达任务下标后移一位
				i++;
			}
			s--;		//当前任务服务时间减少1
		}
		return list;
	}
	public void printList(List<task> list){		//打印输出各任务的属性
		task t=new task();
		System.out.println("任务编号\t到达时间\t服务时间\t开始时间\t完成时间\t周转时间\t带权周转时间");
		for(int i=0;i<list.size();i++){
			t=list.get(i);
			System.out.println(t.getTaskID()+"\t"+t.getArrivalTime()+"\t"+t.getServiceTime()+"\t"+
			t.getStartingTime()+"\t"+t.getFinishingTime()+"\t"+t.getTurnAroundTime()+"\t"+t.getWeightTurnAroundTime());
		}
	}
}
