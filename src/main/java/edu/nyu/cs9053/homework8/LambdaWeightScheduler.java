package edu.nyu.cs9053.homework8;

import java.util.*;

public class LambdaWeightScheduler{
	
	private List<Job> schedule;
	
	/*dp means dynamic programming*/
	private	List<List<Job>> dpSchedule=new ArrayList<>();/*dpSchedule[i] is the best schedule for the ist end time*/ 
	
	private	List<Integer> dpGain=new ArrayList<>();/*dpGain[i] is the best sum of weight for dpSchedule[i]*/
	
	private	List<Long> allEndTime=new ArrayList<>();/*allEndTime is the end time of all jobs*/
		
	public LambdaWeightScheduler(List<Job> jobs){
		if(jobs.isEmpty()){
			System.out.println("No jobs to do!");
		}
		else{
			sortByEndTime(jobs);
			initialize(jobs);
			dpSolve(jobs);
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
	
	private void initialize(List<Job> jobs){
		allEndTime.add(0L);
		dpGain.add(0);
		dpSchedule.add(Collections.emptyList());
		for(Job job:jobs){
			allEndTime.add(job.getEndTime());
			dpGain.add(0);
			dpSchedule.add(Collections.emptyList());
		}
	}

	private void dpSolve(List<Job> jobs){
		for(int i=0;i<jobs.size();i++){
			int j=0;
			while(jobs.get(i).getStartTime()>=allEndTime.get(j)){
				int curGain=dpGain.get(j)+jobs.get(i).getWeight();
				if(dpGain.get(i+1)<curGain){
					List<Job> curSchedule=new ArrayList<>(dpSchedule.get(j));
					curSchedule.add(jobs.get(i));
					dpSchedule.set(i+1,curSchedule);
				}
			}
		}
		this.schedule=dpSchedule.get(dpSchedule.size()-1);
	}
	
}
