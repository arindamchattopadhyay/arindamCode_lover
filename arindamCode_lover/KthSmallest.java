import java.util.*;
public class KthLargest
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int k=sc.nextInt();//input for the kth largest element
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
   		 for(int i: a){
        	q.add(i);
 
        if(q.size()>(n-k+1)){
            q.poll();
        }
    }
 
    System.out.println(q.peek());
	}

}
