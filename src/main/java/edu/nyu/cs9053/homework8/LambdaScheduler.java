package edu.nyu.cs9053.homework8;

import java.util.*;

public class LambdaScheduler{
	
	private List<Job> schedule;
	
	public LambdaScheduler(List<Job> jobs){
		if(jobs.isEmpty()){
			System.out.println("No jobs to do!");
		}
		else{
			int i;
			sortByEndTime(jobs);
			schedule.add(jobs.get(0));
			for(i=1;i<jobs.size();i++){
				/*greedy*/
				if(jobs.get(i).getStartTime()>=schedule.get(schedule.size()-1).getEndTime()){
					schedule.add(jobs.get(i));
				}
			}
		}
		
	}
	
	/*return the target schedule*/
	public List<Job> getSchedule(){
		return schedule;
	}

	private void sortByEndTime(List<Job> jobs){
		int i,j;
		for(i=0;i<jobs.size()-1;i++){
			for(j=i+1;j<jobs.size();j++){
				if(jobs.get(i).getEndTime()>jobs.get(j).getEndTime()){
					Collections.swap(jobs,i,j);
				}
			}
		}
	}
}
