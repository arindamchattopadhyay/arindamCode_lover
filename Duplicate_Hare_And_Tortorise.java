import java.util.*;
public class Duplicate_Hare_And_Tortorise{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int slow=a[0];
		int fast=a[a[0]];
		while(slow!=fast)
		{
			slow=a[slow];
			fast=a[a[fast]];
		}
		//check the entrance point of the cycle.
		fast=0;
		while(slow!=fast)
		{
			slow=a[slow];
			fast=a[fast];
		}
		System.out.println(fast);
	}
}