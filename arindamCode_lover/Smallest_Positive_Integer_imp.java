//Smallest Positive Integer in an unsorted array O(n)

// Explanation:-- We will not be bothered about the negatives.
/*
0|1|2|3
--------
3|4|-1|1    array elements.

so if we get,like these 
1|2|3|4
--------
1|2|5|6

We can see that the third index doesn't match with the element , so it's the lowest element missing.
like the 1st element in the 1st array is 3, as the array indices start from 0, we need the see whether the 
3rd element i.e -1 is equal to 3.
it is not.


1|2|3|4
-------
1|4|3|1
 
whenever, the indices and the elements match, we shift to the next index(i.e 1)
cause (1,1)

a[3]=4
a[0]=1,val=1
so, both are equal , next iteration and goes.


@author: Arindam Chattopadhayay
*/
import java.util.*;
public class Smallest_Positive_Integer{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int val,nextval;

		for(int i=0;i<n;i++)
		{
			if(a[i]<=0||a[i]>n)
				continue;
			val=a[i];
			while(a[val-1]!=val)
			{
				nextval=a[val-1];
				a[val-1]=val;
				val=nextval;
				if(val<=0||val>n)
					break;
			}

		}

		for(int i=0;i<n;i++)
		{
			if(a[i]==i+1)
				return (i+1);
		}
		return (n+1);

	}


}
