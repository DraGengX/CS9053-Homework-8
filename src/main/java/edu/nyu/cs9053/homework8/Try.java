import java.util.*;

class Try{
	public static void main(String[] args){
		List<Integer> row=new ArrayList<>();
		List<List<Integer>> matrix=new ArrayList<>();
		row.add(1);
		row.add(2);
		matrix.add(row);
		matrix.add(row);
		row.add(3);
		List<Integer> new_row=new ArrayList<>(row);
		row.add(4);	
		for(int i=0;i<new_row.size();i++)
			System.out.print(new_row.get(i));
	
	
	
	}
}
