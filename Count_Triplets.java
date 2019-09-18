import java.util.*;
public class Count_Triplets {
	static Scanner sc=new Scanner(System.in);
public static void main(String args[])
{
	
	int n=sc.nextInt();
	int a[]=new int[n];
	Count_Triplets.getdata(a, n);
	System.out.println(Count_Triplets.countTriplets(a, n));
}
public static void getdata(int a[],int  n)
{
	int i;
	for(i=0;i<n;i++)
	{
		a[i]=sc.nextInt();
	}
}
public static int countTriplets(int arr[],int n)
{
	int max=Integer.MIN_VALUE;
	for(int i=0;i<n;i++)
	{
		max=Math.max(max, arr[i]);
	}
	int freq[]=new int[max+1];
	for(int i=0;i<n;i++)
	{
		freq[arr[i]]++;
	}
	
	int ans=0;
	ans+=freq[0]*(freq[0]-1)*(freq[0]-2)/6;
	
	for(int i=1;i<=max;i++)
	{
		ans+=freq[0]*freq[i]*(freq[i]-1)/2;
	}
	
	for(int i=1;(2*i)<=max;i++)
	{
		ans+=freq[i]*freq[2*i]*(freq[i]-1)/2;
	}
	
	for(int i=1;i<=max;i++)
	{
		for(int j=i+1;i+j<=max;j++)
		ans+=freq[i]*freq[j]*(freq[i+j]);
	}
	
	
	return ans;
	
}
}