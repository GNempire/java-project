package sjf;

public class task {
	private int taskID;
	private int arrivalTime;
	private int serviceTime;
	private int startingTime;
	private int finishingTime;
	private int turnAroundTime;
	private int weightTurnAroundTime;
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public int getWeightTurnAroundTime() {
		return weightTurnAroundTime;
	}
	public void setWeightTurnAroundTime(int weightTurnAroundTime) {
		this.weightTurnAroundTime = weightTurnAroundTime;
	}
}
