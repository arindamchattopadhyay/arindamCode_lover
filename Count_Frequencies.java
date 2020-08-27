/*
the elements are in the range of [1,n]
@author: Arindam Chattopadhyay
@date : 27-08-2020
*/
import java.util.*;
public class Count_Frequencies
{
	//Provided the elements are in the range of [1,n]
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			a[i]--;
		}
		for(int i=0;i<n;i++)
		{
			a[a[i]%n]+=n;
		}
		StringBuilder sb=new StringBuilder();

		for(int i=0;i<n;i++)
		{
				if((a[i]/n)>0)
					sb.append(i+1+" --> "+a[i]/n).append("\n");

		}
		System.out.println(sb);
	}
}