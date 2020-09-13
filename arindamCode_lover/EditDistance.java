/*Given two strings str1 and str2 and below operations that can performed on str1.
Find minimum number of edits
(operations) required to convert ‘str1’ into ‘str2’.*/
import java.util.*;
public class EditDistance {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the string  str1  :--  ");
	String str1=sc.next();
	System.out.println("Enter the string  str2  :--  ");
	String str2=sc.next();
	
	
	System.out.println("Min edits to convert  :---   "+str1+" to "+str2 +"   is = "+EditDistance.editString(str1, str2,str1.length(),str2.length()));
	
}
public static int editString(String str1,String str2,int n,int m)
{
	int dp[][]=new int[n+1][m+1];
	for(int i=0;i<=n;i++)
	{
		for(int j=0;j<=m;j++)
		{
			if(i==0)
				dp[i][j]=j;
			else if(j==0)
				dp[i][j]=i;
			else if(str1.charAt(i-1)==str2.charAt(j-1))
				dp[i][j]=dp[i-1][j-1];
			else
				dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
			
			
		}
	}
	return dp[n][m];
	
}
}
