//Merge Overlapping Intervals
import java.util.*;
public class Merge_Intervals{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		 int n=sc.nextInt();
	     int intervals[][]=new int[n][2];
	    
	     for(int i=0;i<n;i++)
	     {
	         for(int j=0;j<2;j++)
	            intervals[i][j]=sc.nextInt();
	     }
	     int res[][]=merge(intervals);
	     for(int i=0;i<res.length;i++)
	     {
	         for(int j=0;j<2;j++)
	         {
	             System.out.print(res[i][j]+" ");
	         }
	     }
	    
	}

	 public static int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> res=new ArrayList<>();
        int[] current_interval=intervals[0];
        res.add(current_interval);
        
        for(int[] interval:intervals){
            int current_begin=current_interval[0];
            int current_end=current_interval[1];
            int next_begin=interval[0];
            int next_end=interval[1];
            
            if(current_end>=next_begin)
                current_interval[1]=Math.max(current_end,next_end);
            else
            {
                current_interval=interval;
                res.add(current_interval);
            }
        }
        return (res.toArray(new int[res.size()][]));
            
    }
}
