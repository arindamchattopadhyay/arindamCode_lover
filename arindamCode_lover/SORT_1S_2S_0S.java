//SORT 0'S,1'S AND 2'S WITHOUT ANY SORTING ALGORITHM.
import java.util.*;
public class SORT_1S_2S_0S
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
		int n0=0,n1=0,n2=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]==0)
				n0++;
			else if(a[i]==1)
				n1++;
			else
				n2++;
		}
		for(int i=0;i<n;i++)
		{
			if(i<n0)
				a[i]=0;
			else if(i>=n0&&i<(n0+n1))
				a[i]=1;
			else 
				a[i]=2;
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}

	}
}