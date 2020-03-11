import java.util.*;
public class Minimum_Subset_Difference{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		int sum=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			sum+=a[i];
		}
		
		boolean dp[][]=new boolean[a.length+1][sum+1];
		for (int i=0;i<=a.length; i++) {
			for (int j=0; j<=sum; j++) {
				if(i==0&&j==0)
					dp[i][j]=true;
				else if(i==0)
					dp[i][j]=false;

				else if(j==0)
					dp[i][j]=true;
				else if(a[i-1]<=j)
					dp[i][j]=dp[i-1][j-a[i-1]]||dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j];

			}
		}
		ArrayList<Integer> ob=new ArrayList<Integer>();
		for(int i=0;i<=(sum/2);i++)
		{
			if(dp[a.length][i]==true)
			ob.add(i);
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<ob.size();i++)
		{
			if((sum-2*ob.get(i))<min)
			{
				min=(sum-2*ob.get(i));
			}
		}
		System.out.println("Minimum subset sum = "+min);


	}
	
}