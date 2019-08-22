import java.util.*;
public class Egg_Dropping {
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of eggs :---  ");
		int n=sc.nextInt();
		System.out.println("Enter the number of storeys :---  "); 
		int k=sc.nextInt();
		int s=Egg_Dropping.eggdropping(n, k);
		System.out.println("Maximum number of trials :---  "+s);
	}
	
	
	public static int eggdropping(int n,int k)
	{
		int dp[][]=new int[n+1][k+1];
		
		for(int i=1;i<=n;i++)
		{
			dp[i][0]=0;
			dp[i][1]=1;
		}
		for(int j=1;j<=k;j++)
		{
			dp[1][j]=j;
		}
		
		
		for(int i=2;i<=n;i++)
		{
			for(int j=2;j<=k;j++)
			{
				dp[i][j]=99999999;
				for(int x=1;x<=j;x++)
				{
					int res=(1+Math.max(dp[i-1][x-1],dp[i][j-x]));
					if(res<dp[i][j])
						dp[i][j]=res;
					
				}
			}
		}
		return dp[n][k];
		
	}
}
