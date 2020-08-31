/*Majority Element in an array, provided there's only one such element
We can easily solve it with the help of hash map. But we will use a brute force method optimally in constant space.

*/

import java.util.*;
public class Majority_Element{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int el=-1,cnt=0;
		for(int i=0;i<n;i++)
		{
			if(cnt==0)//Suppose we have 5 (3) times,4(1) time and 2(2) times, so, we can see that we don't have any majority.(3-3=0 cancelling out)
				el=a[i];
			if(a[i]==el)
				cnt++;
			else
				cnt--;
		}
		System.out.println("The majority element in the array is :- "+el);
	}
}