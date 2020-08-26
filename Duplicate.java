//Maintaining the order in which  the repetion took place. 
import java.util.*;
public class Duplicate{
	public static void main(String args[])
	{
		//provided the a[i] in [1,n]
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}


		int f=0;
		for(int i=0;i<n;i++)
		{
			if(a[a[i]%n]>n){
				if(a[a[i]%n]<2*n)
				{
				
					sb.append(a[i]%n).append(" ");
					f=1;
				}
				
			}
			a[a[i]%n]+=n;
		}

		if(f!=1)
			sb.append("-1");

		

		System.out.println(sb);
	}
}
//ip :- 1 6 3 1 3 6 6