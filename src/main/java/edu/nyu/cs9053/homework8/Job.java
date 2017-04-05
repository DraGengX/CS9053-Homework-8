package edu.nyu.cs9053.homework8;

public class Job {
	
	/*since getTime() returns long, I use long here*/
	
	private final long startTime;
	
	private final long endTime;
	
	private final int weight;

	public Job(long startTime,long endTime,int weight){
		this.startTime=startTime;
		this.endTime=endTime;
		this.weight=weight;
	}

	public long getStartTime(){
		return startTime;
	}
	
	public long getEndTime(){
		return endTime;
	}
	public int getWeight(){
		return weight;
	}



}
